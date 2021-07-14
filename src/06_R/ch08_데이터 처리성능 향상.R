####################################
##### 8장. 데이터 처리 성능 향상 ###
####################################

  # plyr패키지(apply 계열 함수 대치)
  #  데이터 구조 변경( melt, cast)      ##########매우매우매매매매매매우 중요
  # 데이터테이블 


#### 1. plyr 패키지 ####

install.packages("plyr")
library(plyr)

apply(iris[,1:4],2,mean)
apply(iris[,1:4],2,FUN=function(col){mean(col)})


x <- data.frame(v1=c(4,9,16),
                v2=c(16,81,196))


x

apply(x,2,function(col){sum(sqrt(col))})
adply(.data=x, .margins=2, .fun=function(col){sum(sqrt(col))})


# 종별 Sepal.Length 평균, Sepal.Width 평균

library(doBy)
summaryBy(Sepal.Length+Sepal.Width ~ Species, data=iris, FUN=mean)

ddply(.data=iris, .(Species), function(group){
  data.frame(SL.mean=mean(iris$Sepal.Length),
             SW.mean=mean(iris$Sepal.Width))
})


# summarise : 명시된 변수들만 출력
ddply(.data=iris, .(Species), summarise,SL.mean=mean(iris$Sepal.Length),
      SW.mean=mean(iris$Sepal.Width) )


#### 2. 데이터 구조 변경 (melt, cast 함수)
head(airquality)
edit(airquality)

install.packages("reshape2")
library(reshape2)

airquality.melt <- melt(airquality, id=c('Month','Day'), value.name='val')
head(airquality.melt)

# melt 를 통해 바뀐 구조(5월5일 데이터)

subset(airquality, Month==5&Day==5)
subset(airquality.melt, Month==5&Day==5)
subset(airquality, Month==5&Day==1)
subset(airquality.melt, Month==5&Day==1)

airquality.melt <- melt(airquality, id=c('Month','Day'), na.rm=T)
airquality.melt


# melt 된 데이터를 복구 : dcast , acast 와 둘의 차이점 

airquality.dc <- dcast(airquality.melt, Month+Day ~ variable)
head(airquality.dc)

airquality.ac <- acast(airquality.melt, Month+Day ~ variable)
head(airquality.ac)

airquality.ac['5_1',]




###  데이터 구조 변경 예


df1 <- read.csv('D:\\jk\\bigdata\\download\\csvfile\\전국 평균 평당 분양가격(2013년 9월부터 2015년 8월까지).csv',header=T)
edit(df1)
table(is.na(df1))

df1.melt <- melt(df1, id=c('지역'), value.name='price')
head(df1.melt)
str(df1.melt)
df1.melt$variable <- as.character(df1.melt$variable)

#variable 에서 연도 뽑기
variable

as.integer(substr(variable,2,5))

df1.melt$연도 <- as.integer(substr(df1.melt$variable,2,5))

edit(df1.melt)

# variable 에서 월 뽑기
variable <- 'X13년12월'
monthStr <- strsplit(variable,'년')[[1]][2]
monthStr <- substr(monthStr,1,nchar(monthStr)-1)
as.integer(monthStr)

getMonth <- function(variable){
  monthStr <- strsplit(variable,'년')[[1]][2]
  monthStr <- substr(monthStr,1,nchar(monthStr)-1)
  as.integer(monthStr)
}
getMonth('X2013년12월')
df1.melt$variable

df1.melt$월 <- sapply(df1.melt$variable, getMonth)








edit(df1.melt)



df1.melt$variable <- NULL

head(df1.melt)




df2 <- read.csv('D:\\jk\\bigdata\\download\\csvfile\\주택도시보증공사_전국 신규 민간아파트 분양가격 동향_20210531.csv',header=T)
df2


dim(df2)

head(df2)

df2 <- df2[df2$규모구분=='모든면적',]
head(df2)
df2$규모구분 <- NULL
df2
head(df2)

str(df2)

colnames(df2) <- c('지역','연도','월','price_per_m')
df2[df2$price_per_m=='',]
colSums(is.na(df2))
df2$price_per_m <- as.integer(df2$price_per_m)


df2$price <- df2$price_per_m * 3.3

head(df1.melt,2)
head(df2[,c('지역','연도','월','price')],2)

df <- rbind(df1.melt,df2[,c('지역','연도','월','price')] )
edit(df)

#### 3. 데이터 테이블 


flightDF <- read.csv('inData/flights14.csv')
dim(flightDF)
head(flightDF)
tail(flightDF)
class(flightDF)

install.packages("data.table")
library("data.table")

flight <- fread('inData/flights14.csv')
.libPaths()



# flightsDF 데이터프레임에 대해 작성 제출(yisy0703@naver.com)
# 1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
resul <- flightDF %>% 
      filter(origin=='JFK' & month==5)

resul

# 2. 처음 두 행을 resul에 얻는다
head(resul,2)

# 3. origin으로 오름차순, desc로 내림차순으로 정렬하여 출력
flightDF %>% 
  arrange(desc(origin))


flights[order(flights$origin, -flights$dest)]  # 데이터 프레임 형태로 출력



# 4. arr_delay열만 출력
flightDF[,'arr_delay']
flightDF[,'arr_delay', drop=F]

flights[, .(arr_delay)] # 데이터 프레임 형태로 출력


# 5. year열부터 dep_time열까지 출력
flightDF[,1:4]

subset(flights, select=c(year:dep_time)) # 데이터 프레임 형태로 출력



# 6. year열과 dep_time열 출력
flightDF[,c('year','dep_time')]

flights[, .(년도=year, 실제출발=dep_time)]

# 7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
flightDF %>% 
  summarise(delay_arr = arr_delay,
            delay_dep = dep_delay)
flightDF
flights[,c(year,dep_time)]
flights[, .(year, dep_time)]


# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
ex8 <- flightDF %>% 
  filter(arr_delay <0 & dep_delay < 0)
count(ex8)
nrow(flightDF[flightDF$arr_delay<0 & flightDF$dep_delay <0,])

flights[arr_delay<0 & dep_delay<0, .(cnt=.N)]



# 8-1 지연시간의 합이 0미만인 비행이 몇 번인지 출력
ex8_1 <- flightDF %>% 
  filter(arr_delay + dep_delay < 0)
count(ex8_1)

flights[arr_delay+dep_delay <0, .(.N)]

# 9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
flightDF %>% 
  filter(origin == 'JFK' & month==6) %>% 
  summarise(mean_arr=mean(arr_delay),
            mean_dep=mean(dep_delay))


flights[origin=='JFK' & month==6, .(mean(arr_delay), mean(dep_delay))]



# 10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
flightDF %>% 
  filter(origin == 'JFK' & month==6) %>% 
  summarise(mean_arr=mean(arr_delay),
            mean_dep=mean(dep_delay))



# 11. JFK 공항의 6월 운항 횟수
ex11 <- flightDF %>% 
  filter(origin =='JFK' & month=='6')
count(ex11)
edit(ex11)

flights[origin=='JFK' & month==6, .N]


# 12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
flightDF %>% 
  filter(month=='6') %>% 
  select(arr_delay, dep_delay)

# 13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
flightDF %>% 
  filter(month=='6') %>% 
  select(-arr_delay, -dep_delay)

flights[origin=='JFK' & month==6, -c("arr_delay","dep_delay")]

# 14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
flightDF %>% 
  group_by(origin) %>% 
  summarise(cnt = n())
  
flights[, .(.N), by=.(origin)]


# 15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산


flightDF %>% 
  filter(carrier == 'AA') %>% 
  group_by(origin) %>% 
  summarise(cnt=n())
  
  
# 16. origin, dest별로 비행횟수 출력

filghtDF %>% 
  group_by(origin, dest) %>% 
  summarise(cnt= n())

flights[, .(.N), by=.(origin, dest)]

# 17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
filghtDF %>% 
  filter(carrier == 'AA') %>% 
  group_by(origin, dest) %>% 
  summarise(cnt= n())




# 18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
flightDF %>% 
  filter(carrier=='AA') %>% 
  group_by(origin, dest) %>%  
  summarise(mean_arr = mean(arr_delay),
            mean_dep = mean(dep_delay))

# 19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
ex19 <- table(flightDF$dep_delay>0 ,flightDF$arr_delay>0)
ex19
  

# 20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
flightDF %>% 
  filter(origin=="JFK") %>% 
  group_by(month) %>% 
  summarise(maxarr = max(dep_delay))



install.packages('data.table')
library('data.table')





flights <- fread('inData/flights14.csv')
class(flights)



# 지연 시간 순으로 정렬

flights[origin=='JFK', .(max=max(dep_delay)), by=.(month)]
