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
