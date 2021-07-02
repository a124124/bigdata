###################################
### 5장. 데이터 전처리          ###
###################################


### 1. 파일 입출력 


## 1.1 시스템 인코딩 조회

# A(65) 가 
Sys.getlocale() # Windows 는 CP949

## 1.2 write.table : 데이터를 파일에 저장

iris
class(iris)
getwd()
?write.table
write.table(iris, file='outData/iris.csv', sep=',')
write.table(iris, file='outData/iris.csv', sep=',', row.name=F)

InsectSprays
summary(InsectSprays)

str(InsectSprays)


write.table(InsectSprays, file='outData/insect.csv', sep=',', row.names=F)

## 1.3 read.table : 파일의 내용을 데이터프레임 형태로 읽어옴 

irisData <- read.table('outData/iris.csv', sep=',') # 첫번째 행도 데이터로 읽어들임임


irisData <- read.table('outData/iris.csv', sep=',', header =T, encoding = 'utf-8' )


head(irisData)
str(irisData)  # Species 를 문자형으로 읽어들임 

irisData <- read.table('outData/iris.csv', sep=',', header =T, stringsAsFactors = T )

str(irisData)

emp <- read.table('indata/emp.csv', sep=',', header= TRUE, stringsAsFactors = T) 

str(emp)


## 1.4 write.csv

write.csv(iris, file='outData/iris1.csv')
write.csv(iris, file='outData/iris1.csv', quote = F, row.names= F)



## 1.5 read.csv


newIris <- read.csv('outData/iris1.csv', header = T)
head(newIris)
str(newIris)
?read.csv
newIris$Species <- as.factor(newIris$Species)
str(newIris)
newIris$Species <- as.character(newIris$Species)
newIris$Species <- factor(newIris$Species, levels = c('setosa','versicolor','virginica'))

newIris[c(1,51,101),'Species']

str(newIris)
summary(newIris)


# 1.6 cat을 이용한 text 출력

cat('Hello, R','\n', file='outData/irisSummary.txt', append=T)

irisSummary <- summary(iris)

class(irisSummary)
dim(irisSummary)
irisSummary[1,]
irisSummary[2,]

cat('iris 통계 요약치','\n', file='outData/irisSummary.txt')

for(i in 1:nrow(irisSummary)) {
  cat(irisSummary[i,],'\n', file='outData/irisSummary.txt', append=T)
}





### 2. apply 계열 함수 적용

## 2.1 apply 
# iris 데이터의 열별 (평균,합계,표준편차,최소값,최대값,중앙값)

  # apply(대상자료, 1또는 2, 함수)

iris[,-5]
iris[,1:4]

apply(iris[,1:4],2,mean) # 열별 평균
apply(iris[,1:4],1,mean) # 행별 평균


#apply 계열 함수를 이용하면 반복문 사용보다 코드가 최소화되고, 수행속도가 빠르다.

# -apply : 행렬 배열 차원 별로 지정한 함수 적용 (1:행별 적용 2: 열별 적용용)

apply(iris[,1:4],2,FUN=mean) # 열별 평균
apply(iris[,1:4],2,FUN=sum) #열별 합계
apply(iris[,1:4],2,FUN=sd) #열별 표준편차
apply(iris[,1:4],2,FUN=min)
apply(iris[,1:4],2,FUN=max)
apply(iris[,1:4],2,FUN=median) #중앙값

unique(iris$Species)
levels(iris$Species)

#종별 (setosa, versicolor, virginica) 열별(Sepal.Length  Sepal.Width Petal.Length  Petal.Width) 평균 구하기

iris
setosa <- apply(iris[iris$Species == 'setosa', -5],2,FUN=mean)
versicolor <- apply(iris[iris$Species == 'versicolor', -5],2,FUN=mean)
virginica <- apply(iris[iris$Species == 'virginica', -5],2,FUN=mean)

setosa
versicolor
virginica
data.frame(setosa, versicolor, virginica)

names(setosa)

# 학생

name <- c('A','B','C','D','E')
kor <- c(90,89,87,85,94)
eng <- c(65,86,99,84,84)
mat <- c(79,99,77,85,64)
student <- data.frame(name, kor, eng, mat)
student
rownames(student) <- name
rownames(student)

#학생별 평균,
apply(student[,-1],1,mean)
m
#과목별 평균,
apply(student[,-1],2,mean)


## 2.2 lapply : list apply (결과도 list)

# - lapply : list apply (함수를 적용한 결과를 list로 반환)

lapply(iris[1:4],mean)
list.iris <- as.list(iris[1:4])
lapply(list.iris, mean)

exp(-3:3) #e 의 -3승부터 3승까지 7개


x <- list(a=1:10, beta=exp(-3:3), logic = c(T,F,F,T,T))
x

lapply(x, mean)
lapply(x, quantile)
lapply(x, quantile, 1:3/4)
quantile(c(1:10), probs= 1:3/4)       
quantile(exp(-3:3))


## 2.3 sapply : lapply 와 유사하나 결과가 행렬이나 벡터로 반환

sapply(iris[1:4],mean)

sapply(x, mean)
sapply(x, quantile)
sapply(x, quantile, 1:3/4)

fivenum(1:100)

seq(1,100,length.out=5)

i39 <- sapply(c(3:9),seq)
i39

lapply(i39, fivenum)
sapply(i39, fivenum)



## 2.4 vapply
  # - vapply : sapply와 유사하나 FUN의 모든 값이 FUN.VALUE와 호환되는지 확인한다.


vapply(i39, FUN=fivenum, FUN.VALUE = c(numeric(1),numeric(1),numeric(1),numeric(1),numeric(1)))

sapply(iris[1:4],mean)
vapply(iris[1:4],mean, FUN.VALUE = numeric(1))




cities <- c('Seoul','Busan','NewYork','Tokyo')
nchar(cities)
lapply(cities, nchar)
sapply(cities, nchar)
vapply(cities, nchar, FUN.VALUE = numeric(1))


## 2.5 mapply : 함수 적용시 여러개의 인자를 함수에 전달

  # - mapply : 여러개 인자를 함수에 전달

rep(c(1,2,3), 3)
rep(c(1,2,3), each=2)
mapply(rep, x=1:5, times=5:1)
mapply(rep, x=c(1:4, 2:3, 10:11, 12:15), times=4:1)
mapply(rep, x=c(1:4, 2:3, 10:11, 12:15), each=c(4,3,2,1))



# 직업별 수입

job <- c(3,3,5,2,2,3,5,3,4,4,6,3)
income <- c(4879,6509,4180,0,3846,0,3877,6815,5381,9051,0,4382)

length(job)
length(income)
cust <- data.frame(job, income)
cust

income.avg <- c(862,0,3806,3990,3891,3359,3556,2169,215)
income.avg

names(income.avg) <- 0:8
income.avg
cust

zero2mean <- function(job, income){
  if(income == 0 & job!=1 ){
    return (income.avg[as.character(job)])  
    
  }else{
    return(income)
  }
}


cust[1,'income'] <- zero2mean(cust[1,'job'],cust[1,'income'])

#for(i in 1:nrow(cust)){
#  cust[i,'income'] <- zero2mean(cust[i,'job'],cust[i,'income'])  
#}
cust


cust$income2 <- mapply(zero2mean, cust$job, cust$income)
cust

apply(iris[,-5],2,mean)




### 3. 데이터 그룹화 함수 적용
  ## 3.1 tapply : 1개 열에 대해 그룹화 처리를 위한 apply
tapply(iris$Sepal.Length, iris$Species, FUN=mean) 

tapply(iris$Sepal.Length, iris[,c('Species','Petal.Length')], FUN=sum)
tapply(iris$Sepal.Length, iris$Species, FUN=sd)
boxplot(iris$Sepal.Length ~ iris$Species)

library(vioplot)

install.packages("vioplot")
require(vioplot)
vioplot(iris$Sepal.Length ~ iris$Species)


str(cust)
tapply(cust$income2, cust$job, FUN=mean)

cust$job <- factor(cust$job, levels=0:8)

levels(cust$job)
tapply(cust$income2, cust$job, FUN=mean)

tapply(cust$income2, cust$job, FUN=mean, default = -1) #default 값은 NA 대체값


datasets::InsectSprays
head(InsectSprays)

# spray의 종류에 따른 살충효과 점검

str(InsectSprays)

tapply(InsectSprays$count, InsectSprays$spray, mean)
tapply(InsectSprays$count, InsectSprays$spray, sd)

boxplot(InsectSprays$count ~ InsectSprays$spray)
vioplot(InsectSprays$count ~ InsectSprays$spray)




## 3.2 -by : 1개 이상의 열에 대해 1개의 함수로 그룹화 처리

by(InsectSprays$count, InsectSprays$spray, sum)

by(iris[,c('Sepal.Length','Sepal.Width')], iris['Species'],FUN = summary)


# cust 직업별 평균, 중위수, 1사분위수, 3사분위수, 최소값, 최대값을 income, income2를 한꺼번에 (summary)

by(cust[,c('income','income2')], cust$job, FUN=summary)


## 3.3 doBy 패키지

summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width ~ Species, iris)
  
install.packages("doBy")
library(doBy)

?summaryBy

summaryBy(Sepal.Length+Petal.Length ~ Species, iris, FUN=c(mean, sd))
summaryBy(Sepal.Length+Petal.Length ~ Species, iris, FUN=sd)
summaryBy(Sepal.Length+Petal.Length ~ Species, iris, FUN=c(mean, sd, median))


#문 1 emp.csv 파일의 데이터를 받아, 부서별 급여와 상여금을 비교(mean, sd)
getwd()
emp <- read.csv('indata/emp.csv', header=T)

str(emp)
emp$deptno <- factor(emp$deptno, levels = seq(10, 40, 10))
levels(emp$deptno)

summaryBy(sal + comm ~ deptno,  emp,  FUN=c(mean,sd), na.rm=T)

# 문2 emp.csv 파일의 데이터를 받아 부서별, job별 급여와 상여금 비교(mean, sd)
str(emp)
emp
emp$job <- as.factor(emp$job)

summaryBy(sal + comm ~ deptno + job,  emp,  FUN=c(mean,sd), na.rm=T)



# (2) orderBy : 정렬

orderBy(~Sepal.Length, data=iris)

orderBy(~Species+Sepal.Length, data=iris)

orderBy(~Species+Petal.Length, data=iris)

orderBy(~-Sepal.Length, data=iris)

orderBy(~-Sepal.Length+Species, data=iris)

orderBy(~-Sepal.Length-Species, data=iris)


# 종별, Sepal.Length 오름차순으로 정렬한 데이터의 Sepal.Length, Species, Petal.Length 열만 출력


orderBy(~Species+Sepal.Length+Petal.Length, data=iris)[,c(-2,-4)]


# 문1  emp데이터셋에서 월급이 적은 순으로 ename, sal 을 추출

orderBy(~sal, data=emp)[ c('ename','sal')]


# 문2 emp 데이터셋에서 월급이 적은 순으로 5명만 ename, sal 추출

head(orderBy(~sal, data=emp)[,c('ename','sal')],5)



# (3) simplyBy : 그룹별 데이터를 샘플링

library(doBy)

iris
sampleBy(~species, data=iris) #frac 은 기본값이 10%
sampleBy(~species, data=iris, frac=0.2) #종별 20%씩 비복원추출
sampleBy(~species, data=iris, frac=0.2, replace =T) #종별 20%씩 복원 추출
sampleBy(~species, data=iris, frac=0.2, systematic = T)


sample(1:150, 10)  # 1 부터 150중에서 10개를 추출 

iris[sample(1:nrow(iris),10),]



### 4. Formula : ~ +
## lm() 선형회귀식 도출 한수



x <- c(1,2,3,4,5)
y <- c(20,45,55,60,70)
y <- c('C','C','B','B','A')
y <- c('C','C','B','B','A')

plot(x,y)

fit <- lm(y ~ x)
fit
lines (x, x*11.5+15.5, col='red')
abline(fit, lty='dashed', lwd="3")


# 독립변수가 2개

x1 <- c(1,2,3,4,5) # 시간
x2 <- c(4,8,3,4,6) #기출문제집 푼 개수
y1 <- c(70,80,61,97,73) # x1과 x2의 상관관계가 없다는 전제에서 독립변수 2개

lm(y1 ~ x1 + x2)

# y1 2.3*x1 + 1.5*x2 + 61.8


# datasets::cars

cars  # 속도에 따른 제동거리의 관계를 선형회귀식으로 도출(그래프 시각화)

calss(cars)
nrow(cars)


plot(cars, cars$speed)
plot(cars, cars$dist)

plot(cars)

fit <- lm(cars$dist ~ cars$speed)

fit <- lm(dist ~ speed, data=cars)


fit


# y = 3.932 * speed - 17.579


abline(fit, lty='dotted', lwd='3')

lines(cars$speed, 3.932*cars$speed - 17.579, col='red')



### 5.  데이터 분리

## 5.1 split : 결과는 list형태

iris.species <- split(iris, iris$Species)   # 종별로 iris데이터 분리

iris.species 

iris.sepal <- split(iris, iris$Sepal.Length > mean(iris$Sepal.Length))
iris.sepal

iris.sepal$'TRUE'  # Sepal.Length 가 평균보다 큰 그룹
iris.sepal$'F'  # Sepal.Length 가 평균보다 작은 그룹


## 5.2 subset

# Sepal.Length 가 4이상인 데이터만 추출

subset(iris, subset=iris$Sepal.Length>= 4, select=c(1,3,5))


## 6. 데이터 합치기

#열합치기 (컬럼 합치기) cbind()
#행합치기               rbind()



## 6.1 cbind( 열합치기)

(student.a <- data.frame(name=c('lee','kim'),score=c(90,80)))
(student.b <- data.frame(id=c(101,102),gender=c('남','여')))
(student <- cbind(student.a, student.b))
(student <- cbind(student.a, student.b)[,c(3,1,2,4)])




## 6.2 rbind(행합치기)

(student.a <- data.frame(name=c('lee','kim'),score=c(90,80)))
(student.b <- data.frame(name=c('Park','Jung','no'),score=c(50,60,59)))
(student <- rbind(student.a, student.b))



## 6.3 merge (병합하기)

(student.a <- data.frame(name=c('lee','park'),score=c(90,80)))
(student.b <- data.frame(name=c('lee','kim'),eng=c(40,60),mat=c(69,87)))

(student <- merge(student.a, student.b, all=T))


### 7. 데이터 정렬

## 7.1 sort() : 정렬된 데이터 반환 / order() : 정렬

data <- c(10,30,100,1,3)
data

sort(data, decreasing = T)


names(data) <- c('1','2','3','4','5')
names(data)

sort(data)
order(data)
data[order(data)] # sort(data) 와 같음

#iris 데이터를 Sepal.Length 기준으로 내림차순 정렬
orderBy(~-Sepal.Length, data = iris) # (1)


sort(iris$Sepal.Length, decreasing = T)
order(iris$Sepal.Length, decreasing = T)
iris[order(iris$Sepal.Length, decreasing =  T),] # (1)과 동일 


# iris 데이터를 Sepal.Length 기준으로 내림차순 정렬 
orderBy(~-Sepal.Length, data=iris)[,c('Sepal.Length','Species')]



# 문 emp데이터셋에서 월급이 많은 순으로 ename, sal을 추출

emp[order(emp$sal, decreasing = T),c('ename','sal')]
# 문2 월급이 많은 top5 ename, sal

head(emp[order(emp$sal, decreasing = T),c('ename','sal')],5)
# 문3 월급이 적은 top5 ename, sal

tail(emp[order(emp$sal, decreasing = T),c('ename','sal')],5)



### 8. 데이터 프레임 이름 생략하기 

## 8.1 with절, within절

iris.temp <- iris
iris.temp[c(1,3),1] <- NA
head(iris.temp,3)


# Sepal.Length 의 종별 중앙값

mps <- tapply(iris.temp$Sepal.Length, iris.temp$Species, FUN=median, na.rm=T)
mps['setosa']
mps['versicolor']
mps['virginica']
iris.temp$Sepal.Length2 <- iris.temp$Sepal.Length # Sepal.Length가 NA가 아닐경우

iris.temp$Sepal.Length2 <- mps[iris.temp$Species] # Sepal.Length가 NA일 경우


iris.temp$Sepal.Length2 <- ifelse(is.na(iris.temp$Sepal.Length),
                                  mps[iris.temp$Species],
                                  iris.temp$Sepal.Length)


head(iris.temp[,c('Sepal.Length','Sepal.Length2')],3)


## with절

iris.temp <- with(iris.temp, {
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length) 
  
})
head(iris.temp)
iris.temp$Sepal.Length2 <- within(iris.temp, {
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length)
})



## 8.2 attach(), 
attach(iris)  # 지금부터 iris$ 를 생략해도된다.

summary(iris$Species)
summary(Species)

find("Species")
Sepal.Length
tapply(Petal.Length, Species, mean)
detach(iris)



### 9. 데이터 집계

## 9.1 table()

table(iris$Species) #종별 개수
table(InsectSprays$spray)


# emp 데이터 셋에서 deptno별 집계

table(emp$deptno)

## 9.2 aggregate() : 1개 이상의 열애 대해 1개 이상의 그룹화 처리리(적용함수 1개씩만 가능)
aggregate(iris[,1:4], by=list(iris[,5]), FUN=mean)
tapply(iris$Sepal.Length, iris$Species, mean)
by(iris$Sepal.Length, iris$Species, mean)
summaryBy(Sepal.Length+Petal.Length ~ Species, data=iris, FUN=mean)



# 보험회사 

cust_id <- c(1001,1002,1004,1005,1001,1002,1001,1003,1001,1002)

hos_day <- c(10,2,4,1,7,2,34,8,20,6)

data <- data.frame(cust_id, hos_day)

data



day_per_cust <- aggregate(data$hos_day, by=list(data$cust_id), FUN=sum)

class(day_per_cust)
names(day_per_cust) <- c('cust_id','hos_day')
day_per_cust

day_per_cust[order(-day_per_cust$hos_day),]

### 10. 조건으로 색인 찾기

which(iris$Species == 'setosa')
iris[which(iris$Species == 'setosa'),]
which.min(iris$Sepal.Length) # 최소값이 있는 데이터
iris[which.min(iris$Sepal.Length),]

which.max(iris$Sepal.Length) # 최대값이 있는 데이터
iris[which.max(iris$Sepal.Length),]
