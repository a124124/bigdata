######################### 3장. R 데이터 종류 및 구조


## 1. 데이터 종류
      # 기본 데이터타입: 문자, 숫자, 논리 복소수 = 스칼라 타입
      # factor(남,여), vector, list, matrix, array, data.frame, 날짜, 특별한 값값(결측치) 

a <- 10

kor <- c('한국','일본')

edit(iris)


a <- 10+7i;

class (a)

## 2. 기본 데이터 타입 : character, numeric, logical(TRUE : T, FALSE : F), complex

a <- 'hello'
a <- "hello"

a <- 'i say, "hello"'
a <- 'i say, "
he
llo"'

cat(a)

class(a)

mode(a)
typeof(a)

methods(is) # is로 시작하는 함수들
is.character(a) # a 변수가 character 인지 여부
as.character(100) #100을 character로 형변환한 결과 반환


# numeric : 정수, 실수

b <- 10.1

b <- 10

is.numeric(b)
as.character(b)
as.integer(10.9)

#logical

c <- TRUE;

is.logical(c)

class(c)

as.numeric(c)
as.character(c)

str(a) # str() R의 내부 구조를 간결하게 표시

str(b)
str(c)

# 3. 특별한 값(NULL, NA; 결측치, NAN)

result <- 0

add <- function(a,b){
  result <<- a+b
  return()
}
 
temp <- add(1,2) 
result
(temp <- add(b=10, a=1))


is.null

d <- c(2,4,NA,6,NaN,10/0) #vector(동일 자료형 집합)

mean(d, na.rm=T)
mean(d, na.rm= TRUE)

d <- c(2,4,NA,6,NaN) # 결측치를 제외한 값들의 평균

mean(d, na.rm = T)

# 결측치 NA 관련함수
# is.na(d) : 결측치인지 아닌지 여부 반환
# complete.case(d): d 변수에 결측치가 없으면 TRUE
# na.omit(d) 결측치 제외하고 리턴


d <- c(2,4,6,NA,8,10)

d[1]
is.na(d)
is.na(d[4])
?is.na
complete.cases(d)

# d에서 결측치가 아닌 값만 뽑아내기

d[c(1,2,3,5,6)]


d[complete.cases(d)]

na.omit(d)

mean(d, na.rm=TRUE)
boxplot(d)


## 4. factor : 범주형데이터, 순서식

gender1 <- c('남','여','남','여')

gender1[4]
gender1[5] <- '중성'
gender1

class(gender1) # vector 변수의 타입은 요소 하나하나의 타입

gender <- factor(c('남','여','남','여') ,levels=c('남','여'))
gender
gender[5] <- '중성'

gender

class(gender)

str(gender)
na.omit(gender)

nlevels(gender) #level의 갯수
levels(gender) #카테고리 출력


level <- factor(c("좋음","보통","보통"), levels=c("매우좋음","좋음","보통","나쁨","매우나쁨"), ordered=TRUE)

level

level[4]="매우좋음"
level[5]="몰라라"
level
nlevels(level)
levels(level)

gender <- c('남','남','여','중성')

gender

class(gender)

#character <-> factor


gender <- as.factor(gender)  #범주형 변수로 변환

gender <- as.character(gender) #범주형 변수를 character 벡터 변수로 변환

class(gender)

gender <- as.character(gender)
gender <- factor(gender, levels=c("남","여")) #범주형 변수로 변환(추천)



gender


## 5. 구조형 변수와 복합형 변수 : 변수 하나에 여러 값 할당 
    # (1) 구조형 변수 : 동일 자료형
    #       ex. 벡터, 행렬(회귀분석 용이), 배열(n차원)
    # (2) 복합형 변수 : 서로 다른 자료형을 가질 수 있다.
    #       ex. 리스트, 데이터프레임(csv)

## 6. 벡터 : 동일 자료형

data <- c(11,22,33,'test')
data <- c(11,22,33,TRUE)
data <- c('a',TRUE)
data <- c(10,20,1+10i, 'hello',TRUE)
data
class(data)

data <- 1:4
data
data <- 1:10
data


data[4] <- 40
data

#특정한 값 조회

data[1] #첫번째 값 반환
names(data) <- c('a','b','c','d','e','f','g','h','i','j')
data
data[1] # 첫번째 값 반환
data['a'] #A열 값 반환
data[c(1,2)] #1번째, 2번째 값을 반환

data[c('a열','b열','c열','d열')]

data[c(1:4)]
data[1:4]
data[c('a열':'d열열')]

data[-2]
data[-c(2,3)] #2,3 번째 제외

data[data>4]

data[c(T,T,T,T,F,F,F,F,T,T)]

names(data)
data['a열']

# 항목갯수

length(data)
NROW(data)
nrow(data)


2 %in% data            # data에 2가 포함되어있는지 여부를 true false로 알려줌


# q. (1) 시험점수 변수를 만들어 출력하고 (2) 전체 평균을 구한 후 출력(평균=xx)
  # a,  b,    c,  d,     e,  f
  # 80, 100, 90, 미응시, 70, 70

score <- c(80, 100, 90, NA, 70, 70)
score

names(score) <- c('a','b','c','d','e','f')

score

avg <- mean(score, na.rm = TRUE)
avg
cat('평균 = ', avg)

paste('평균 =',avg)

score[score>=80]

# (3) 80점 이상만 출력(NA제외)

temp <- score[complete.cases(score)]
temp[temp>=80]






######################## 함수 ###############################
ax2_b.add <- function(a=0, b=0){
  return(2*a + b)
}
ax2_b.add()    #a , b = 0

ax2_b.add(10)  #a= 10, b= 0
 
ax2_b.add(b=10) #a= 0, b= 10

ax2_b.add(10,1) #a= 10, b= 1


#########################################

a <- 10
class(a)

# 6.1 character() : character 벡터 생성하는 함수 

charVector <- character() # 길이 0인 문자벡터를 생성 

charVector


is.vector(charVector)

class(charVector)

length(charVector)

charVector[1] <- 'R'

charVector

charVector <- character(5) # 길이가 5인 문자 벡터

charVector

charVector[1] ='안녕'; charVector[2]='R'; charVector[3]='수업중'

charVector

charVector[6] <- 'test'

charVector

charVector[8] <- 'test2'

charVector


# 6.2 numeric()

intVec <- numeric() # 길이가 0인 숫자 벡터
intVec

is.vector(intVec)

class(intVec)

intVec <- numeric(2)

intVec

intVec[3] = 12.1
intVec

intVec[5] = 35
intVec

intVec[7] = 9.67
intVec

intVec[4] = 'r'
intVec

intVec

# 6.3 logical()

logicVec <- logical()

logicVec[1] <- TRUE
logicVec

logicVec[2] <- F
logicVec


# 6.4 seq

?seq

(a <- seq(from=1, to=10, by=1))

seq(1,10)

seq(1,10,2)

seq(from=1,to=10,by=2)

seq(from=1,to=100, length.out=11)


a <- seq(1, 100, 11)
is.vector(a)


seq(10,-10,-2)

seq(0,1,0.1)

seq(1,9,pi)


pi <- 3
pi

cat <- 10

cat('pi 값은 ', pi)

cat <- function(a,b){
  return(a+b)
}
rm(cat)

# 6.5 rep()

?rep

# rep(x, times=1, length.out = NA, each = 1)

rep(1:4, 2)

rep(1:4, times=2)

rep(1:4, each=2)

rep(1:4, 2, 5, 2)

rep(1:4, times=2, each=2)

rep(1:4, times=2, length.out= 5, each=2)

# 6.6 벡터의 연산(+,-,*,/, 결합, 교집합, 합집합, 차집합, 벡터비교연산)

a <- c(1,2,3)
b <- c(10,20,30)

a + b

a - b

a * b

a / b

a %% b # 나머지 연산

c(a,b)

a <- c(1,2,3)

b <- c('hello', 'r')

c <- c(T,F)

c(a,b,c) # 다른타입의 벡터 결합시 타입이 자동으로 바뀜
  # 자동형변환 룰 : character > complex > numeric > logical

a <- append(a, c(4,5,6))
a

a[8] <- 8

a[10] <- 10
a

# 벡터의 집합 연산 : 합집합(union), 교집합(intersect), 차집합(setdiff), 비교(setequal)

a <- c(1,2,3,4,5,6)
b <- c(2,4,6,8,10,12)
union(a,b)
intersect(a,b)
intersect(b,a)
setdiff(a,b)
setdiff(b,a)

setequal(a,b)
setequal(c(1,2),c(2,1))

setequal(a, c(intersect(a,b), setdiff(a,b)))

## 7. 리스트 : 복합 구조형(키값 형태로 데이터를 담는 복합 구조형)

student <- list(name='홍길동', age='25')

student
student['name']
student$name
student[1]    # $name [1]홍길동
student[[1]]  # [1]홍길동

student$score <- 100

student$age <- NULL

student
NROW(student)
length(student)

studentVec <- unlist(student) #list 를 벡터로(동일 자료형으로 변환)

is.vector(studentVec)

studentVec

as.list(studentVec)


student2 <- as.list(studentVec)
student2
student



## 8. 행렬

colMatrix <- matrix(1:15, nrow=5, ncol=3)
colMatrix
?matrix

# dimnames
rowMatrix <- matrix(1:15, nrow=5, ncol=3, byrow = TRUE, dimnames = list(c("R1","R2","R3","R4","R5"),c("C1","C2","C3")))
rowMatrix

rowMatrix[1,3]
rowMatrix['R1','C3']
rowMatrix[1:3,1:2]
rowMatrix['R1':'R3','C1':'C2']
rowMatrix[c(1,3,5),]
rowMatrix[c('R1','R3','R5'),]
rowMatrix[, c('C2','C3')]
rowMatrix[c(1,3,5)]

dim(rowMatrix)  # 차원수( 행,열수 )

NROW(rowMatrix) #행 수
nrow(rowMatrix)
NCOL(rowMatrix) #열 수
ncol(rowMatrix)
dimnames(rowMatrix) #차원 이름
dimnames(rowMatrix) <- list(c('1행','2행','3행','4행','5행'))
rowMatrix

rownames(rowMatrix) <- c('1월','2월','3월','4월','5월')
rownames(rowMatrix)
colnames(rowMatrix) #열이름
colnames(rowMatrix) <- c('a','b','c')

rowMatrix

rowMatrix['1월','a', drop=F] # 1월 a열의 데이터를 matrix 형태로 반환

rowMatrix

rowMatrix['1월',]  # 1월 데이터가 벡터 형태로 반환

rowMatrix['1월', , drop=FALSE] #1월 데이터가 matrix 형태로 반환 
rowMatrix

rowMatrix[c(1:3),c(1:2)]

rowMatrix[-3,c('a','b')] 
rowMatrix[-3,] # 3행 제외한 모든 열
rowMatrix[-3] # 3번째 데이터를 제외한 모든 데이터가 벡터형태로 1차원 반환


# 행렬의 곱(%*%), 전치행렬(행과 열을 교환), 대각행렬(cf. 단위행렬), 역행렬


payMatrix <- matrix(c(12000,26000,18000), ncol=3)
payMatrix



dimnames(payMatrix) <- list(c('시급'),c('철수','김철','김수'))
payMatrix

workerMatrix <- matrix(c(c(5,4,9), c(7,3,2)), nrow=3, dimname = list(c('철수','김철','김수'),
                                                                    c('5월','6월')))

workerMatrix

# payMatrix(1x3 행렬) workerMatrix(3x2 행렬)

cost <- payMatrix %*% workerMatrix
cost

rownames(cost) <- c('인건비')

cost['인건비',]


# 전치행렬 (행과 열을 교환)
rowMatrix <- matrix(1:15, nrow=5, ncol=3, byrow = T, dimnames = list(c('R1','R2','R3','R4','R5'), c('C1','C2','C3')))


rowMatrix

t(rowMatrix)

# 역행렬

X <- matrix(1:4, nrow=2, byrow = F)
X


solve(X)

X %*% solve(X)

# 단위행렬 : 대각 행렬을 구하는 diag() 함수 이용
diag(c(1,1)) 
diag(rep(1,3))

# 행렬의 곱을 이용한 선형회귀식 도출

x <- c(2, 4) # 독립변수 : 공부량
y <- c(40,60) # 종속변수 : 점수

X <- matrix(c(x, rep(1, NROW(x))), nrow=NROW(x), ncol=2, byrow=FALSE)
X
Y <- matrix(y, ncol=1)
Y

#              X %*% ab =              Y
# solve(X) %*% X %*% ab = solve(X) %*% Y
#                    ab = solve(X) %*% Y

ab <- solve(X) %*% Y
ab

ab[1] # x의 기울기
ab[2] # 절편

plot(x,y)
lines(x, x*ab[1]+ab[2], col=2, lty='dotdash', lwd=4)

lines(x, y, col=1, lty=1)

# 공부량을 5시간으로하면 예측되는 종속변수는?

ab[1] * 5 + ab[2]

# 행렬의 곱을 이용한 선형회귀식 도출(데이터 8개)

x <- c(32,64,96,118,126,144,152.5,158)
y <- c(18,24,61.5,49,52,105,130.3,125)       

X <- matrix(c(x,rep(1,NROW(x))),nrow=NROW(x), ncol=2)
X

Y <- matrix(y)
Y

# X가 8x2 행렬 t(X)가 2X8 행렬
# X %*% ab = Y
# t(X) %*% X %*% ab = t(X) %*% Y
# solve(t(X) %*% X) %*% X %*% ab = solve(t(X) %*% X) %*% t(X) %*% Y
# ab = solve(t(X) %*% X) %*% t(X) %*% Y

ab <- solve(t(X) %*% X) %*% t(X) %*% Y
ab

lm(y~x) # 회귀식을 도출하는 함수

plot(x,y)
lines(x,x*ab[1]+ab[2], col=2)


# 행렬의 곱을 이용한 다변량 선형회귀식 도출(독립변수 3개)

x1 <- c(60, 65, 55)
x2 <- c(5.5, 5.0, 6.0)
x3 <- c(1, 0, 1)
y <- c(66,74,78)

X <- matrix(c(x1,x2,x3), nrow=NROW(x1), ncol=3)
X
Y <- matrix(y,ncol=1)
Y

# X %*% ab = Y
# solve(X) 

ab <- solve(X) %*% Y
ab

solve(X, Y)

80*ab[1] + 6.5*ab[2] + 0*ab[3]

X

dimnames(X) <- list(c('Lee','Park','Kim'),c('몸무게','키','흡연'))

X

dataFrame <- as.data.frame(X)
dataFrame
class(dataFrame)
class(X)


(a <- matrix(1:4, nrow=2, ncol=2))

(b <- matrix(seq(10,40,10),nrow=2, ncol=2))
a
b
a * b 
a %*% b
a + b
a / b
a %% b
a ^ b

dataArray <- array(1:24, dim=c(3,4,2)) # 3차원 numeric 배열
dataArray
dataArray[3,2,1]
dim(dataArray)
nrow(dataArray)
NROW(dataArray)
ncol(dataArray)
NCOL(dataArray)
length(dataArray) # 요소의 갯수 : 24

dataArray
dimnames(dataArray) <- list(c('1행','2행','3행'),c('1열','2열','3열','4열'),c('x면','y면'))
dataArray

dim(dataArray) <- c(3,8)
dataArray

dim(dataArray) <- c(3,4,2)
dataArray

attr(dataArray, 'dim') <- c(3,8)
dataArray

## 10. 데이터 프레임  중요중요중요중요중요중요중요중요중요중요중요중요중요중요중요중요중요중요

edit(iris)


# (1) 데이터 프레임 생성

student_id <- c('20211','20212','20213','20214')
student_name <- c('Jin','Eric','Den','Kei')
student_kor <- c(100,95,90,85)
student_eng <- c(88,90,94,97)
student_mat <- c(89,58,87,62)
student_gender <- c('남','여','남','여')
student_data <- data.frame(student_id, student_name, student_kor, student_eng, student_mat, student_gender)

student_data

edit(student_data)

st <- edit(student_data)
st
d <- data.frame(id=c(1,2,3), name=c('김','홍','이'))
d

# (2) 데이터프레임에 열 추가 및 삭제


student_data$mat <- c(100,95,86,75)
student_data
student_data$age <- c(20,20,21,21) # 열 추가
student_data$age <- NULL
student_data$mat <- NULL # 열 삭제
student_data

# (3) 데이터프레임의 열 형 변환

class(student_data)
str(student_data)  # str : 구조 보기

student_data$id <- as.numeric(student_data$student_id)  # 수치형 변환
str(student_data)

student_data$student_gender <- as.factor(student_data$student_gender)
str(student_data)

student_data$student_gender <- as.character(student_data$student_gender)
str(student_data)

student_data$student_gender <- factor(student_data$student_gender, levels=c('남','여'))

str(student_data)

summary(student_data)

# (4) 데이터프레임의 열이름 변경( 모든 열이름 변경, 특정 열이름 변경)

?rename
library(reshape)
.libPaths() #패키지가 설치된 폴더

install.packages("reshape") # 1. 패키지 설치
library(reshape)
?rename
student <- rename(student_data,c("student_id"="id"))  # 특정 열이름 변경

student <- rename(student, c("student_name"="name","student_kor"="kor","student_eng"="eng","student_gender"="gender"))
student <- rename(student, c("student_mat"="mat"))
student
names(student_data)
names(student_data) <- c("id","name","kor","eng","mat","gender")
student_data
student$id <- NULL
# (5) 데이터 프레임 합치기 : cbind, rbind

newStudent <- rbind(student, student_data)
newStudent



# cbind : 열합치기

student
add_data <- data.frame(age=c(30,31,32,25),nickname=c('개똥','말동','길똥','소똥'))
add_data

cbind(student, add_data)


# (6) 데이터프레임의 부분 데이터 조회 


student <- rbind(student, student) 
student
nrow(student)
ncol(student)
names(student)

# 1행 1열 데이터
student[1,1]

# 1행 'id'열
student[1,'id']

# 1행 모든 열
student[1,]

# 모든행 1열 
student[, 1, drop = FALSE]

# 1~3행까지의 모든 열
student[1:3,]

# 모든행의 2,3,4,5열
student[,2:5]

# 2,4,6행 제외한 모든 데이터
student[-c(2,4,6),]

# 1~3행 데이터에서 1열과 5열 제외
student[1:3,-c(1,5)]

# kor 점수가 90점 이상
student[student$kor >= 90, ]

# kor 점수가 90점 이상인 사람의 이름, kor
student[student$kor >= 90, c('name','kor') ]

# subset 함수 :데이터 프레임의 
?subset

subset(student, subset=(student$kor>=90) )
subset(student,(student$kor>=90))
subset(student, subset=student$kor>=90 & student$gender=='남')

subset(student,select = c(1,4))
subset(student,select = c(1:4))
subset(student, select = c('id','name','kor','eng'))
subset(student, select= c(-1,-4)) # 1열, 4열 제외
subset(student, select = c('id','eng'))
# mat 가 99이상인 여학생의 id name mat kor 

subset(student, subset=(mat>=50 & gender =='여'), select = c('id','name','mat','kor'))

# 처음 6행만

student[1:6,]

student[c(1:6),]

head(student)
head(student, 3)

tail(student,3)

tail(student)


# 문

emp <- read.csv(file.choose()) # 탐색기에서 선택한 csv 파일을 변수에 할당
emp

head(emp)
tail(emp)
class(emp)


# 1. 직원이름만 (벡터, 데이터프레임)
emp[,2]
emp[c('ename')]
subset(emp, select='ename', drop=T)
subset(emp, select='ename')

# 2. ename, job, sal
emp[,c(2,3,6)]
emp[c('ename','job','sal')]

# 3. KING 의 empno, job, hiredate, sal

subset(emp,subset=(ename == 'KING'), select = c('empno','job','hiredate','sal'))

# 4. sal이 2000~3000 인 ename, sal

subset(emp, subset=(sal>=2000 & sal<3000) , select =c('ename','sal'))




######## 11. 타입 판별 및 타입 변환

class(iris)
class(iris$Species)
class(emp)
class(emp$empno)
is.factor(iris$Species)
str(iris$Species)

a <- c(1,2,3)
class(a)
mode(a)
typeof(a)

# 형변환

a <- as.integer(a)
typeof(a)
class(a)
str(emp)

emp$deptno <- as.factor(emp$deptno) # 데이터를 다운받을 경우 NA로 추정되는 값이 많아서 추천하지 않는다.
emp$deptno <- factor(emp$deptno, levels=c(10,20,30,40))
# emp$deptno <- factor(emp$deptno, labels=c(10,20,30,40)) 
emp

summary(emp)



## 12. 문자열과 날짜

name <- "Eric"
length(name) # 요소의 갯수 : 1

nchar(name)  # 문자의 길이 

names <- c('Eric','Larray','Curly')
length(names)
nchar(names)

# 하위 문자열 추출하기 : substr

?substr
substr('ABCDEF', 1, 4)
substr('ABCDEF', 4, 16)
substr('ABCDEF',c(1,2),c(1,3))
class(names)
substr(names, 1, 2) 

#names 안에 각각 이름의 맨 마지막자리 앞글자부터 맨 마지막글자

substr(names,nchar(names)-1, nchar(names))

# 문자열 연결하기 : paste() paste0()


names <- c('Eric','Larray','Curly')
paste(names, 'loves','stars.')

paste(names, 'loves','stars.',sep='♡')
paste0(names, 'loves','stars.')
paste(names, 'loves','stars.',sep='♡',collapse='~ ')


# 문

name <- c('Yi','Lim','Kim')
hobby <- c('swim','sleep','eat')

# 결과 : yi의 취미는 swim이고 ...

paste(names, '의 취미는', hobby, '이고', collapse=',')


# 문자 분할 (구분자로 분할하기)

path <- 'home/hadoop/data/speech.csv'
path
strsplit(path,'/')
customerInfo <- 'jin@gmail.com,010-4442-5353,seoul'
strsplit(customerInfo,',010-4442-5353,')

customers <- c('jin@gmail.com,010-4442-5353,seoul', 'yy@gmail.com,010-6546-6578,busan','irn@gmail.com,02-532-7654,daegu')

strsplit(customers, ',010-6546-6578,')
strsplit(customers, ',[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}')


# 문자열 대체 sub(oldStr, newStr, string) 처음 나오는 oldStr을 newStr로 바꿈
#             gsub(oldStr, newStr, string) 
s <- 'Curly is the smart one. Curly is funny, too'
sub('Curly','Kim',s)
gsub('Curly','Kim',s)
s <- 'Curly is the smart one.


Curly is funny, too #$^%$#'

s <- gsub('[#$^%$#\n]','',s)
s

# 외적 : outer ; 문자열의 모든 쌍별 조합 만들기

a <- c('aa','bb','cc')
b <- c('11','22','33')
outer(a,b, FUN= 'paste')

# 날짜

today <- Sys.Date()
today

class(today)

thatDay <- as.Date('21-06-29','%y-%m-%d')
thatDay
thisDay <- as.Date('06/09/2021','%m/%d/%Y')
thisDay

if(thatDay < today) {
  cat('과거')
}


today


######################################### 총괄 연습 문제 #######################################

#1. iris 데이터를 사용하여 data.frame의 특성을 살펴봅니다.
#1) 행과 열에 대한 다양한 참조 방식을 사용하여 데이터를 조회합니다.
# iris 데이터의 차원 확인, 컬럼이름 확인, 구조확인, 속성들
#2) 행과 열 정보를 조회합니다.
# iris의 요약통계 정보
# 꽃받침의 길이 처음 10개 조회
#3) 부분 데이터셋을 추출해 봅니다.
# virginica종만 추출 => virginica
# setosa종 만 추출 => setosa
#4) 추출한 부분 데이터셋을 다시 결합해 봅니다.
#2. setOsa종의 꽃 받침(Sepal)의 폭과 길이 부분 데이터 셋을 추출하세요.
#3. 작업내용에 따른 급여가 차등 지급됩니다.(행렬 문제)
#A작업은 시급 12000원, B작업은 시급 26000원, C작업은 시급 18000원 입니다.#
#두 사람이 각 작업을 수행하는 데 있어서 실제 작업한 시간이 작업 내역에 따라 다릅니다. 갑
#은 A작업을 5시간, B작업을 4시간, C작업을 9시간
#그리고 을은 A작업을 7시간, B작업을 3시간, C작업을 2시간 작업 했습니다.
#갑과 을의 급여를 계산하세요.
#힌트 : 행렬 두 개, 작업당 급여를 저장하는 행렬, 근무자들이 근무한시간
#행렬의 곱은 %*% 를이용한다.
#계산한 갑과 을의 급여는 각각 326000원, 198000원 입니다


#1. iris 데이터를 사용하여 data.frame의 특성을 살펴봅니다.
#1) 행과 열에 대한 다양한 참조 방식을 사용하여 데이터를 조회합니다.


iris
edit(iris)
nrow(iris)
ncol(iris)
length(iris)
head(iris,10)



virginica <- subset(iris,subset=(Species == 'verginica'), )
virginica
