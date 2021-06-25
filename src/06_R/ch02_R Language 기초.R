
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
