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
