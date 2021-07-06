####################################################
##### 6 dplyr 패키지를 이용한 데이터 전처리 ######
####################################################



### 1. 외부파일 read/ write
## 1.1 엑셀 파일 읽어오기 - readxl 패키지 이용

install.packages("readxl")
library(readxl)

getwd()

exam <- read_excel('inData/exam.xlsx') # 첫번째 sheet의 값을 read
exam
head(exam)
class(exam)
str(exam)
exam <- as.data.frame(exam)
exam


exam2 <- as.data.frame(read_excel('inData/exam.xlsx', sheet=2))
exam2

# 데이터 파일에 컬럼명이 없는 경우
city <- read_excel('inData/data_ex.xls', col_names= F)
city <- as.data.frame(city)
head(city,3)
colnames(city) <- c('ID','gender','age','area')
city


## 1.2 데이터 쓰기 (파일(csv)로 쓰기, 변수로 쓰기)

.libPaths()

write.csv(exam, 'outData/exam.csv', row.names = T)


save(exam, file='outData/exam.rda') # exam 변수를 파일에 저장장
rm(list=ls(all.names = T))
exam
load('outData/exam.rda')
head(exam)

### 2. dplyr 패키지 이용을 위한 데이터 준비

data(mpg, package = "ggplot2")
class(mpg)
head(mpg)
midwest <- as.data.frame(ggplot2::midwest)
midwest
tail(mpg)
edit(mpg)

View(mpg)

# dim() 차원
dim(mpg)

str(mpg)
summary(mpg)
#변수명(열이름) (cty -> city, hwy -> highway)

library(ggplot2)
library(dplyr)
mpg <- rename(mpg, city=cty)
mpg <- rename(mpg, highway=hwy)


colnames(mpg)

# 파생변수 (total = (city+highway /2))
mpg$total <- (mpg$city + mpg$highway)/2
mpg

head(mpg,3)

# 파생변수 (total연비가 평균보다 높은 그룹=pass , 평균보다 낮은 그룹= fail)
boxplot(mpg$total) # 박스플롯(1~4 분위수와 이상치를 볼수 있다)

hist(mpg$total)

library(vioplot)
vioplot(mpg$total)


mpg$test <- ifelse(mpg$total >= mean(mpg$total), 'pass','fail')

table(mpg$test)
library(ggplot2)
qplot(mpg$test, color=mpg$test)


mpg <- as.data.frame(ggplot2::mpg)
midwest <- as.data.frame(ggplot2::midwest)


dim(mpg)
str(mpg)
summary(mpg)
hist(mpg$cty)

dev.off()
qplot(mpg$test)


#문제1. ggplot2의 midwest 데이터를 데이터프레임형태로 불러와서 특성 확인

midwest <- as.data.frame(ggplot2::midwest)
class(midwest)
dim(midwest)
midwest


head(midwest,2)

edit(midwest)

colnames(midwest) #열이름
names(midwest)


table(is.na(midwest)) # 결측치 개수 파악
is.na(midwest)        
colSums(is.na(midwest)) # 열별 결측치 개수


# 문제2. poptotal 을 total로, popasian 을 asian으로 변수명 변경

?midwest
midwest <- rename(midwest, total=poptotal, asian=popasian)
colnames(midwest)


# 문제3. total, asian 변수를 이용해 '전체 인구 대비 아시아 인구 백분율' 파생변수를 만들고,
# 히스토그램을 만들어 도시들이 어떻게 분포하는지 살펴보세요

midwest$retioasian <- midwest$asian / midwest$total * 100
midwest$retioasian

head(midwest[,c('state','total','asian','retioasian')])


hist(midwest$retioasian)


# •	문제4. 아시아 인구 백분율 전체 평균을 구하고, 평균을 초과하면 "large", 그 외에는 "small"을 부여하는 파생변수를 만들어 보세요.

midwest$group <- ifelse(midwest$retioasian>mean(midwest$retioasian), "large",'small')



table(midwest$group)

# •	문제5. "large"와 "small"에 해당하는 지역이 얼마나 되는지, 빈도표를 만들어 확인해 보세요.
#빈도표, 빈도그래프 ( 히스토그램-연속변수, 막대그래프-카테고리컬 변수)

table(midwest$group) # 빈도표

qplot(midwest$group)

### 3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 , 분석
  ## 3.1 조건에 맞는 데이터 추출하기 : filter() , %>% , ctrl+shift+m

exam <- read.csv('inData/exam.csv', header=T)
library(dplyr)

#class가 1인 행만 추출

exam %>% filter(class == 1)
exam[exam$class==1,]


# class가 1,2,3 인 데이터 추출

exam %>% 
  filter(class %in% c(1,2,3))


# class 1,2 and english 80 over 

exam %>% 
  filter(class %in% c(1,2) & english >= 80)


## 3.2 필요한 변수 추출 : select()

subset(exam, select=c('class', 'english', 'math'))

exam %>% 
  select(class, english, math)


exam %>% 
  select (-math) # math 제외 전부 출력

#class 가 1or2 인 영어, 수학만 출력
exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(english, math)


exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(3,4)

# class 가 1or2 3,4,5 출력

exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(3:5)


exam %>% 
  select(math, english, science) %>% 
  filter(class %in% c(1,2))


# class 가 1,2,3 인 영어 수학 앞 5개만 출력

exam %>% 
  filter(class %in% c(1,2,3)) %>% 
  select(english, math) %>% 
  head(5)

#3.3 정렬하기 : arrange()

exam %>%arrange(math) # math 기준으로 오름차순 정렬

exam %>%arrange(desc(math)) # 내림차순
exam %>%arrange(-math)      # 내림차순 


exam %>%arrange(class, -math) # 1순위 class, 2순위 math 

#id 가 1 ~10 , 영어 수학, 영어성적 오름차순 6명만

exam %>% 
  filter(id %in% c(1:10)) %>% 
  select(english, math) %>% 
  arrange(english) %>% 
  head(6)


## 3.4 파생 변수 추가 : mutate()


exam %>% 
  mutate(total = math+english+science) %>% 
  filter(total >= 150) %>% 
  arrange(total) %>% 
  head(5)

head(exam)

exam$total <- NULL


exam %>% 
  mutate(total = math+english+science,
         avg = round(total/3),
         group = ifelse(total>=180, 'A','B')) 



apply(iris[,1:4],2,mean)

## 3.5 요약하기 : summarise()
# summarise 안에 들어갈 통계치 함수 : mean, sd, min, max, median, n(갯수)


exam %>% 
  summarise(mean_math=mean(math))

exam %>% 
  summarise(mean_math=mean(math),
            sd_math=sd(math),
            mean_eng=mean(english),
            sd_eng=sd(english),
            cnt = n())


## 3.6 집단별로 요약하기 : group_by() + summarise()

exam %>% 
  group_by(class) %>% 
  summarise(mean_math = mean(math),
            sd_math = sd(math),
            mean_eng = mean(english),
            sd_eng = sd(english),
            cnt = n())


# summaryBy 를 이용하여 위의 식과 동일하게

library(doBy)
result1 <- summaryBy(math+english ~ class, data=exam, FUN=c(mean,sd))
result1
result2 <- table(exam$class)
result2 <- data.frame(result2)
names(result2) <- c('class','cnt')
cbind(result1,result2)
names(result2)
merge(result1,result2)

ggplot2::mpg

# mpg 데이터에서 회사별로 'suv 자동차의 도시와 고속도로 통합 연비 평균을 구해 내림차순으로 정렬하고 1-5 출력
mpg <- as.data.frame(ggplot2::mpg)
class(mpg)
head(mpg)
table(mpg$class)

# 방법 1. dplyr 패키지
mpg %>% 
  filter(class=='suv') %>% 
  group_by(manufacturer) %>% 
  mutate(total = round((cty+hwy)/2)) %>% 
  summarise(tot_mean = mean(total)) %>% 
  arrange(-tot_mean) %>% 
  head(5)
mpg$class

df <- mpg[mpg$class=='suv',]

df$total <- (df$cty+df$hwy)/2

head(sort(tapply(df$total, df$manufacturer, mean)),5)

sort(tapply(df$total, df$manufacturer, mean))[1:5]

#######################
## 혼자 해보기 (1)  ###
#######################
# 혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요.
# • Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. displ(배기량)이 4
# 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지
# 알아보세요.
mpg %>% 
  filter(displ <= 4 | displ >= 5) %>% 
  mutate(group=ifelse(displ<=4,"4이하",ifelse(displ>=5,'5이상',NA))) %>% 
  group_by(group) %>% 
  summarise(mean_total = mean(hwy))
mpg %>% 
  filter(displ >= 5)


mpg %>% 
  filter(displ<=4) %>% 
  mutate(total = round((cty+hwy)/2)) %>% 
  summarise(tot4 = round(mean(total)))

df <- mpg
df$group <- ifelse(df$displ<=4, "4이하",ifelse(df$displ>=5,"5이상",NA))
table(df$group,useNA='ifany') #useNA='ifany' 추가하면 결측치까지
head(df)

  
mpg %>% 
  filter(displ>=5) %>% 
  mutate(total = round((cty+hwy)/2)) %>% 
  summarise(tot = round(mean(total)))




# • Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다. "audi"와 "toyota"
# 중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가 평균적으로 더 높은지
# 알아보세요.
mpg

mpg %>% 
  filter(manufacturer == 'audi') %>% 
  summarise(mean(cty))


mpg %>% 
  filter(manufacturer == 'toyota') %>% 
  summarise(mean(cty))



# • Q3. "chevrolet"
# , "ford", 
# "honda" 자동차의 고속도로 연비 평균을 알아보려고
# 합니다. 이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요

mpg %>% 
  filter(manufacturer %in% c('ford','chevrolet','honda')) %>% 

  mutate(total = round((cty+hwy)/2)) %>% 
  summarise(tot = mean(total))


#######################
## 혼자 해보기 (2)  ###
#######################
# 혼자서 해보기 2 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
# • Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에
# 활용하려고 합니다. mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해
# 새로운 데이터를 만드세요. 새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어
# 있는지 확인하세요.

mpg

ex2 <- mpg %>% 
  select(class, cty)
ex2


# • Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 앞에서 추출한 데이터를
# 이용해서 class(자동차 종류)가 "suv"인 자동차와 "compact"인 자동차 중 어떤
# 자동차의 cty(도시 연비)가 더 높은지 알아보세요.

ex2 %>% 
  filter(class %in% c('suv','compact')) %>% 
  group_by(class) %>% 
  summarise(mean_cty = mean(cty))
  


# • Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지
# 알아보려고 합니다. "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 자동차의
# 데이터를 출력하세요.

ex3 <- mpg %>% 
  select(manufacturer ,class, hwy)
ex3 %>% 
  group_by(class) %>% 
  summarise(mean_hwy = mean(hwy)) %>% 
  head(5) %>% 
  arrange(-mean_hwy)

#######################
## 혼자 해보기 (3)  ###
# #######################
# 혼자서 해보기 3. mpg 데이터를 이용해서 분석 문제를 해결해보세요.
# mpg 데이터는 연비를 나타내는 변수가 hwy(고속도로 연비), cty(도시 연비) 두 종류
# 로 분리되어 있습니다. 두 변수를 각각 활용하는 대신 하나의 통합 연비 변수를 만들어
# 분석하려고 합니다.
# • Q1. mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를
# 추가하세요.

mpg1 <- mpg
mpg1 %>% 
  mutate(ttl = cty+hwy)

# • Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요.
mpg1 %>% 
  mutate(ttl = cty+hwy,
         avg_ttl = ttl/2)
# • Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.
mpg1 %>% 
  mutate(ttl = cty+hwy,
         avg_ttl = ttl/2) %>% 
  group_by(class) %>% 
  summarise(mean_avg=mean(avg_ttl)) %>% 
  arrange(-mean_avg) %>% 
  head(3)



 
  
  
# • Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어
# 출력하세요. 데이터는 복사본 대신 mpg 원본을 이용하세요.
mpg %>% 
  mutate(ttl = cty+hwy,
         avg_ttl = ttl/2) %>% 
  group_by(class) %>% 
  summarise(mean_avg=mean(avg_ttl)) %>% 
  arrange(-mean_avg) %>% 
  head(3)



#######################
## 혼자 해보기 (4)  ###
#######################
# 
# 혼자서 하기4. mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# • Q1. mpg 데이터의 class는 "suv"
# , "compact" 등 자동차를 특징에 따라
# 일곱 종류로 분류한 변수입니다. 어떤 차종의 연비가 높은지 비교해보려고 합니다. 
# class별 cty 평균을 구해보세요.
mpg %>% 
  filter(displ <= 4 | displ >= 5) %>% 
  mutate(group=ifelse(displ<=4,"4이하",ifelse(displ>=5,'5이상',NA))) %>% 
  group_by(group) %>% 
  summarise(mean_total = mean(hwy))

mpg
mpg %>% 
  mutate(group=class) %>% 
  group_by(group) %>% 
  summarise(mean_ttl = (cty+hwy)/2)



tapply(df$hwy,df$group,mean)


# • Q2. 앞 문제의 출력 결과는 class 값 알파벳 순으로 정렬되어 있습니다. 어떤
# 차종의 도시 연비가 높은지 쉽게 알아볼 수 있도록 cty 평균이 높은 순으로
# 정렬해 출력하세요.




# • Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다. 
# hwy 평균이 가장 높은 회사 세 곳을 출력하세요.


mpg %>% 
  group_by(manufacturer) %>% 
  summarise(mean_hwy = mean(hwy)) %>% 
  arrange(-mean_hwy)


# • Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고
# 합니다. 각 회사별 "compact" 차종 수를 내림차순으로 정렬해 출력하세요.

mpg %>% 
  filter(class=='compact') %>% 
  group_by(manufacturer) %>% 
  summarise(cnt = n()) %>% 
  arrange(-cnt)



### 4. 데이터 합치기 ###
  # 열합치기: cbind, left_join(dplyr 패키지 함수)
  # 행합치기: rbind, bind_rows(dplyr 패키지 함수)


library(dplyr)

## 4.1 열합치기(가로 합치기)

test1 <- data.frame(id=c(1,2,3,4,5),
                    midterm=c(100,200,400,500,800))
test2 <- data.frame(id=c(1,2,3,4,5),
                    final=c(55,66,77,88,99),
                    teacherid=c(1,1,2,2,3))
teacher <- data.frame(teacherid=c(1,2,3),
                      teachername=c('Kim','Park','Hong'))
cbind(test1,test2) # 공톤된 열이 중복 생성
merge(test1,test2)

left_join(test1,test2,by='id')
test2

merge(test2, teacher, by='teacherid')
left_join(test2, teacher, by='teacherid')

test2 <- data.frame(id=c(1,2,3,4,5),
                    final=c(55,66,77,88,99),
                    teacherid=c(1,1,2,2,4))
teacher <- data.frame(teacherid=c(1,2,3),
                      teachername=c('Kim','Park','Hong'))
left_join(test2, teacher, by='teacherid')
merge(test2, teacher, by='teacherid', all=TRUE)


## 4.2 행합치기(세로 합치기)

group.a <- data.frame(id=c(1,2,3,4,5),
                      test=c(100,90,80,70,60))
group.b <- data.frame(id=c(6,7,8,9,10),
                      test=c(50,55,60,65,100))

rbind(group.a,group.b)
bind_rows(group.a,group.b)


group.a <- data.frame(id=c(1,2,3,4,5),
                      test1=c(100,90,80,70,60))
group.b <- data.frame(id=c(6,7,8,9,10),
                      test2=c(50,55,60,65,100))

rbind(group.a,group.b) # 안됨
bind_rows(group.a,group.b)
merge(group.a,group.b, all=T)



# 혼자서 해보기 5. mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# mpg 데이터의 fl 변수는 자동차에 사용하는 연료(fuel)를 의미합니다. 아래는 자동차
# 연료별 가격을 나타낸 표입니다.
# fl 연료 종류 가격
# (갤런당 USD)
# c CNG 2.35
# d diesel 2.38
# e ethanol E85 2.11
# p premium 2.76
# r regular 2.22
# 다음문제에서 이용할 연료와 가격으로 구성된 데이터 프레임 fuel을 만들어 보세요
mpg$fl
fuel <- data.frame(fl=c('c','d','e','p','r'),
                   kind=c('CNG','diesel','ethanol E85','premium','regular'),
                   price_fl=c(2.35,2.38,2.11,2.76,2.22))
fuel

 
# • Q1. mpg 데이터에는 연료 종류를 나타낸 fl 변수는 있지만 연료
# 가격을 나타낸 변수는 없습니다. 위에서 만든 fuel 데이터를 이용해서
# mpg 데이터에 price_fl(연료 가격) 변수를 추가하세요.
left_join(mpg, fuel[,c('fl','price_fl')],by='fl')

# (2) merge 사용
data(mpg, package =  'ggplot2')
mpg <- merge(mpg, fuel[,c('fl','price_fl')],by='fl')
mpg

# • Q2. 연료 가격 변수가 잘 추가됐는지 확인하기 위해서 model, fl, 
# price_fl 변수를 추출해 앞부분 5행을 출력해 보세요.

mpg %>% 
  select(model, fl, price_fl) %>% 
  head(5)

subset(mpg,select=c('model', 'fl', 'price_fl'))[1:5,]
head(subset(mpg,select=c('model', 'fl', 'price_fl')),5)


# Q3. mpg에 kind변수도 추가
fuel[,c('fl','kind')]
mpg <- left_join(mpg, fuel[,c('fl','kind')],by='fl')
head(mpg)

#left_join 을 쓰지않고 apply를 이용하여 kind 변수 추가
data(mpg, package='ggplot2')
names(mpg)

fuel[fuel$fl =='c','kind']

flToKind <- function(fl){
  kind <- fuel[fuel$fl==fl,'kind']
  return(kind)
}
flToKind('r')

mpg$kind <- apply(mpg[,'fl', drop=F],1,flToKind)
head(mpg)



#### 5. 데이터 정제하기 ####

## 5.1 결측치 정제하기
df <- data.frame(name=c('Kim','Yi','Yun','Hong','Park'),
                 gender = c('M','F',NA,'F','M'),
                 socre= c(5,4,3,2,NA),
                 income=c(2000,3000,4000,5000,6000))
df
df$gender <- as.factor(df$gender)
dim(df)
is.na(df) # 결측치 여부를 5행 4열 T/F 로 출력
apply(is.na(df),2, sum)
colSums(is.na(df))

str(df)
df

na.omit(df) # 결측치가 하나라도 있는 열을 제외하고 출력. 

library(dplyr)
df %>% 
  filter(!is.na(score)) %>% 
  summarise(mean_score = mean(score))

# 결측치를 대체


x <- c(1,1,2,NA,2,3,2,1,2,3,4,5,6,2,3,350)
mean(x)
median(x)


exam <- read.csv('inData/exam.csv', header=T)
colSums(is.na(exam))
exam[c(3,8,15),'math'] <- NA
exam
exam[1:2,'english'] <- NA


colSums(is.na(exam)) # 결측치 확인


## 결측치를 중앙값으로 대체 

colSums(is.na(exam))
median(exam$math, na.rm=T)

exam$math <- ifelse(is.na(exam$math), median(exam$math, na.rm=T), exam$math)
exam$english <- ifelse(is.na(exam$english), median(exam$english, na.rm=T), exam$english)


colSums(is.na(exam)) # 결측치 대체 후 열별 결측치 확인
table(is.na(exam))
exam


## 결측치를 중앙값으로 대체 2번째 방법

exam[c(3,8,15),'math'] <- NA
exam[1:2,'english'] <- NA
exam[1,'science'] <- NA
exam
colSums(is.na(exam)) # 결측치 확인

m <- apply(exam[,3:5],2,median, na.rm=T) # 결측치를 제외한 중앙값
m

# 결측치 처리 블록

m['math']

exam <- within(exam, {
  math <- ifelse(is.na(math), m['math'], math)
  english <- ifelse(is.na(english), m['english'], english)
  science <- ifelse(is.na(science), m['science'], science)
})

colSums(is.na(exam)) # 결측치 확인

#결측치

exam[c(3,8,15),'math'] <- NA
exam[1:2,'english'] <- NA
exam[1,'science'] <- NA
exam
colSums(is.na(exam)) # 결측치 확인

exam <- exam %>% 
  mutate(
    math = ifelse(is.na(math), m['math'], math),
    english = ifelse(is.na(english), m['english'], english),
    science = ifelse(is.na(science), m['science'], science)
  ) #변수를 만드는 명령어

colSums(is.na(exam)) # 결측치 확인

table(is.na(exam))



## 5.2 이상치 (=극단치, outlier) 정제
  #논리적인 이상치(ex. 성별에 남여가 아닌 값)
  #극단적인 이상치(정상범위 기준에서 벗어나는 값)
  #이상치는 결측치로 대체


# (1) 논리적인 이상치

outlier <- data.frame(gender=c(1,1,2,3,2,3),    #1은 남, 2는 여 
                      score=c(98,65,75,87,36,676))

outlier$gender <- ifelse(outlier$gender !=1 & outlier$gender!=2, NA, outlier$gender) #1
outlier$gender <- factor(outlier$gender, levels=c(1,2), labels= c('남','여'))  #2


outlier$score <- ifelse(outlier$score>100, NA, outlier$score)
outlier


# (2) 정상범위 기준으로 많이 벗어난 이상치 : 상하위 0.3% 
  # 상하위 0.3%또는 평균 - 2.75*표준편차 ~ 평균 + 2.75*표준편차

mpg <- as.data.frame(ggplot2::mpg)

sort(mpg$hwy)
lowlimit <- mean(mpg$hwy) - 2.75*sd(mpg$hwy)
highlimit <- mean(mpg$hwy) + 2.75*sd(mpg$hwy)
highlimit
lowlimit
mpg$hwy[mpg$hwy>highlimit]
mpg$hwy[mpg$hwy<lowlimit]

#

boxplot(mpg$hwy)
result
result <- boxplot(mpg$hwy)$stats
result[1] # 하향 극단치 경계
result[5] #상향 극단치 경계

mpg$hwy[mpg$hwy>result[5]] # 44 41
mpg$hwy[mpg$hwy<result[1]] # 없음

# 이상치를 결측치로 대체
mpg$hwy <- ifelse(mpg$hwy>result[5] | mpg$hwy<result[1], NA, mpg$hwy)
mpg
mpg$hwy
sum(is.na(mpg$hwy))

rm(list=ls())
#########################################
#### 혼자해보기 6 #########
###################################

data(mpg, package='ggplot2')

# • 혼자서 해보기6. mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# • 우선 mpg 데이터를 불러와서 일부러 이상치를 만들겠습니다. drv(구동
#                                         방식) 변수의 값은 4(사륜구동), f(전륜구동), r(후륜구동) 세 종류로 되어
# 있습니다. 몇 개의 행에 존재할 수 없는 값 k를 할당하겠습니다. cty(도
#                                          시 연비) 변수도 몇 개의 행에 극단적으로 크거나 작은 값을 할당하겠습
# 니다.
mpg <- as.data.frame(ggplot2::mpg) # mpg 데이터 불러오기
mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당

# • 이상치가 들어있는 mpg 데이터를 활용해서 문제를 해결해보세요.
# • 구동방식별로 도시 연비가 다른지 알아보려고 합니다. 분석을 하려면
# 우선 두 변수에 이상치가 있는지 확인하려고 합니다.

mpg
boxplot(mpg$cty)


# • Q1. drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음
# 이상치가 사라졌는지 확인하세요. 결측 처리 할 때는 %in% 기호를
# 활용하세요.
mpg$drv
table(is.na(mpg$drv))

mpg$drv <- ifelse(mpg$drv !='f' & mpg$drv !='4' & mpg$drv != 'r', NA, mpg$drv) #1
mpg




# • Q2. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 상자
# 그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시
# 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.


result <- boxplot(mpg$cty)$stats

mpg$cty[mpg$cty>result[5]]
mpg$cty[mpg$cty<result[1]]
mpg$cty <- ifelse(mpg$cty>result[5] | mpg$cty<result[1], NA, mpg$cty)

boxplot(mpg$cty)



# • Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상
# 치를 제외한 다음 drv별로 cty 평균이 어떻게 다른지 알아보세요. 하나
# 의 dplyr 구문으로 만들어야 합니다.



mpg %>% 
  group_by(drv) %>% 
  summarise(mean_cty=mean(cty))




