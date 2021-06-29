
#### 2장. R Language 기초



# 1. 도움말 기능

iris
edit(iris)

? iris #iris 도움말 출력

help("iris") #iris 도움말 출력


# 1.2  검색 기능

??iris

help.search("iris")


# 1.3 패키지 도움말

library(help='datasets')


# 1.4 함수 도움말

methods(as)

as.integer(1.25)


?as.integer


x <- -1:1

x <- c(1,2,3)

x

x <- pi * c(-1:1, 10)
x
as.integer(x)


example("as.integer") #예제 출력


data <- c(10, 20, 30)

mean(data)
?mean


# 1.5 주석

#주석

#자동완성 : tab

R.version

# 1.6 정보

iris

edit(iris)
attributes(iris)

# 2. 패키지
# R 내에 기본 패키지 이외의 패키지는 다운받음
    # 1. 패키지 설치 : install.packages("패키지명")
    # 설치된 패키지를 메모리에 로드 : library("패키지명")
    # 로드된 패키지 안의 데이터나 함수 사용 가능
    # 패키지 언로드 : detach("package:패키지명", unload=TRUE)

dim(available.packages()) # CRAN site에 업로드된 패키지 갯수

available.packages()

install.packages('stringr') # 1. 패키지 설치

library(stringr)
? str_extract

data <- '홍길동 35 이순신 45 김구구 12'
data

str_extract(data, '[1-9]{2}')
str_extract_all(data, '[1-9]{2}')

detach("package:stringr", unload = TRUE)


str_extract(data, '[1-9]{2}')


?iris #datasets (기본적으로 로드되는 패키지)


detach("package:datasets", unload = TRUE)

rm(data) #data 변수를 삭제

iris

data(iris, package="datasets")


# 3. 변수 할당 <-, <<-  <- 지역변수,  <<- 전역변수

result <- 0

result <- 10

class(result)

add <- function(a,b) {
  result <<- a + b
  return(result)
}

add(10,20)

print(result) #전역변수 값 수정됨

 

# 변수 목록 조회

.a <- 10   # 히든 변수
a.10 <- 10
abc <- 10

x <- 10


y <- 10

(z <- x+y)

ls()
?ls

ls(all.names = TRUE)
ls.str()


# 4. 출력

result
print(result)

(a<-10)

msg <- "hello, r"
msg <- "hello, r\nhello,python"
print(msg)

# (2) cat   여러 함수를 묶어서 출력, 행렬이나 리스트 등 복합데이터 구조는 출력 못함

cat(msg)

cat("메세지는", msg)


cat("result =",result)

fibo <- c(0,1,1,2,3,5,8,13,21)  # 벡터(동일자료형의 집합)
cat('피보나치 수열 몇개 :', fibo, '\n')


# (3) paste

paste("result 값은", result)
# print("result 값은", result)

paste("hello","world")

paste0("hello","world")

paste("hello", "world", sep=" ,")

?paste

temp <- paste(c(1,2,3), c("하나","둘","셋"), sep="은 ")
temp

paste(c(1,2,3), c("하나","둘","셋"), sep="은 ", collapse=";")


# (4) paste0

month.abb #월이름 약자
month.name # 월이름
c(1,2,3)
1:3
c(1,2,3,4,5,6,7,8,9,10)
1:10
nth <- paste(1:12,c('st','nd',rep('th',10)),sep="")

paste(month.name, nth, sep=":")
paste(month.name, nth, sep="은 ")
paste(month.name, nth, sep="은 ", collapse=" / ")



# 5. 변수 삭제

ls(all.names= TRUE)


# 특정 변수만 삭제

rm(nth)
nth

# 일반 변수 목록

rm(list=ls())


# 히든 변수까지 다 삭제

ls(all.names = T)
rm(list=ls(all.names = TRUE))

ls(all.names = TRUE)


a <- 10
.a <- 10




### 문1. kor 변수에 "한국",일본","미국"
###      eng 변수에 "korea","japan","USA"
###      출력: 한국:korea, 일본:japan, 미국:USA

kor <- c(한국,일본,미국)
eng <- c("korea","japan","usa")
msg <- paste(kor,eng,sep=":")

### 문2. MASS::Cars93 데이터를 출력

library()
library("MASS")
MASS::Cars93
.libPaths()
Cars93

require("MASS")
require(MASS)

edit(Cars93)
Cars93
head(Cars93)
head(Cars93, 3)
tail(Cars93)
tail(Cars93, 3)

# 패키지 메모리 언로드

detach("package:MASS", unload = TRUE)




### 문3. 도움말

?mean
hep(mean)
?iris                 # 데이터 도움말

library(help="MASS")  # 라이브러리(패키지) 도움말





