####### 4장. R프로그래밍(제어문,연산자,함수)




### 1. 제어문

## (1) if문

num <-9

if( num %% 2 == 0) {
  print(paste(num ,"은 짝수입니다" ))
} else{
  cat(num, "은 홀수")
}  


## (2) ifelse() 함수 : (num%2==0) ? "짝":"홀"

ifelse(num %% 2 == 0, "짝","홀")

(nums <- c(10,9,16,17,20))
result = ifelse(nums %% 2 == 0,"짝","홀")

matrix(c(nums,result), ncol = 5, byrow = T, dimnames = list (c("수","홀짝"), c("1","2","3","4","5")))


## (3) switch() 함수

switch(2, "red","green","blue")
x <- switch(4, "red","green","blue")
x

# 사용자로부터 color 값을 받아 해당 color 출력

?readline
colorValue <- readline(prompt = "컬러값은 (red:1, green:2, blue:3) : ")

colorValue
class(colorValue)

color <- switch (colorValue,"red","green","blue")

cat('1',color)


# 사용자로부터 점수(0~100)을 입력받아 학점을 출력

score <- as.integer(readline("점수는 :"))
grade <- switch(as.integer(score/10),"F","F","F","F","F","F","D","C","B","A","S")

cat('점수는', score, '/ 학점은', grade)

# 함수 = 사용자에게 점수(50~100) 을 받아 학점 출력

getGrade <- function() {
  score <- as.integer(readline("점수는(50~100) :"))
  grade <- switch (as.integer(score/10)-4, "F","D","C","B","A","S")
  cat('점수는', score, '/ 학점은', grade)  
}

getGrade()

## 2. 반복문(for, while, repeat)

1:5
c(1,2,3,4,5)
c(1:4)
seq(1,10)

rep(1:4,2)

x <- c(-2,5,4,8)

for(val in x) {
  cat(val, '\t')
}


# x 벡터에 짝수가 몇개 있는지 출력
x
count <- 0

for(i in x) {
  if(i %% 2 == 0) {
    count = count + 1
  }
}

count


# 안녕하세요 10회 반복

for (i in 1:10) {
  cat (i, 'ㅎㅇ','\n')
}

# 문. factorial 계산 함수를 작성
  # fact(3) 결과 : 3! = 6
  # fact(-3) 결과 : 안됨.
  # fact(0) : 0! = 1

fact <- function(num) {
  result <- 1
  if(num <0) {
    cat('안됨')
    #return()
  }else if(num == 0) {
    cat('0! = 1')
    #return (1)
  }else {
    for (i in num:1){
      result = result * i
    }
    cat(num, '!=', result)
    #return(result)
  }
}
fact(70)

temp <- fact(5)
temp

rm(list=ls(all.name = TRUE))

fact(7)


# factorial.R 저장, 변수 다 삭제

getwd()
setwd('D:/jk/bigdata/src/06_R')
getwd()

fact(7)

source('factorial.R') # 한글 utf-8 로 인고딩된 한글 부분 출력
Sys.getlocale() # 내 OS의 기본 인코딩 체계
source('factorial.R', encoding = 'utf-8')
fact(6)

## (2) while : 조건이 참이면 반복문 수행 
i <- 1
while (i < 6) {
  print(i)
  i <- i + 1
}


## (3) repeat : 반복문

i <- 1
repeat {
  print(i)
  i <- i + 1
  if(i >= 6) break;
}


## (4) break, next(자바에서의 continue)

x <- 0

while(x<7) {
  x <- x+1
  if(x == 3) next;
  cat(x, '  ')
}

### 3. 연산자


## 3.1 벡터 연산

x <- c(11,2,13)
y <- c(1,12,3)
x + y
x>y

x^y  # 승

x%/% y # 몫

x <- c(11,2,13,1,1)
y <- c(1,12,3)

x + y
x+ 1

y+x  



## 3.2 논리 연산자 &, &&, |, ||

T && T

T & T
T & F
T && F

x <- c(T,T,F,F)
y <- c(T,F,T,F)
x && y # 첫번째 요소끼리만 체크
x & y

x | y
x || y

## 3.3 중위연산자

5+8

'+'(5,8)
'%@%' <- function(a , b) {
  return (2*a+2*b)
}

'%@%'(10,15)

10 %@% 15

10 %in% c(10,20,30)

'%*%' <- function(a,b){
  return (a+b)
}

a<- matrix(1:4, ncol=2)
b <- matrix(c(1,0,0,1), ncol=2)
a
b

a%*%b

rm(list=ls())


# %o% : 외적
# %*% : 내적( 행렬의 곱)
a <- c('1','2','3')
b<- c('a','b','c')
outer(a,b, FUN=paste)




a <- c(1,2,3)
b <- c(10,20,30)

a %o% b

matrix.a <- matrix(1:6, nrow=3)
matrix.b <- matrix(1:6, nrow=3)

matrix.a %*% matrix.b

solve(matrix.a)




### 4. 함수



pow <- function(x=1,y=1) {
  return(x^y)
}

pow

i <- 10
i
pow(2,3)

pow(2)

pow(y=3, x=2)

pow1 <- function(x=0, y) {
  return(x^y)
}

pow1(2,3)

pow1(y=2)


# 명시적으로 return() 을 사용할 경우 NULL 이 return된다.

check <- function(x){
  if(x >0) {
    result <- '양수'
    return(result)
  }else if(x <0){
    result <- '음수'
    return(result)
  }else {
    return()
  }
}

(temp <- check(-5))


# 명시적으로 return함수가 없는 경우 


check <- function(x){
  if(x >0) {
    result <- '양수'
   
  }else if(x <0){
    result <- '음수'
  
  }else {
    result <- '0'
  }
}
(temp <- check(-5))
(temp <- check(5))
(temp <- check(0))

# 가변인자함수

total()
total(1)
total(1,2)
total(1,2,3)
total(1,2,3,4)
total(1,2,3,4,5)
total <- function(...){
  args <- c(...)
  sum <- 0
  for(val in args){
    sum <- sum + val
  }
  return (sum)
}


total(1,2,3,4,5,6,7,87,9)

total(3,8,100)
total()



# 재귀함수: 함수내에서 내 함수를 호출하는 함수
# fact(3) = 3*2*1
# fact(3) = fact(3) * fact(2)
# fact(n) = fact(n)* fact(n-1)

recurse.fact <- function(num) {
  if(num < 0){
    cat('안됨')
    return()
  }else if(num == 0){
    return(1)
  }else{
    return (num* recurse.fact(num-1))
  }
  
}


temp <- recurse.fact(3)
recurse.fact(10)

temp <- recurse.fact(5)
temp




### 5. R 환경과 유효범위


environment()
ls()
f <- function(f_x) {
  g <- function(g_x) {
    print('g 함수')
    print(environment())
    print(paste('g함수 영역의 변수들:',ls()))
  }
  g(5)
  print('f함수')
  print(environment())
  cat('F 함수 영역의 변수들:',ls())
}

f(5)
f(10)


# 연습문제

# 소수 체크
# if와 for를 이용하여 매개변수가 소수(prime Number)인지 아닌지 TRUE나 FALSE를 return하는 함수를 작성하고 호출

for(i in 1) {
  
}


P <- function(num) {
  flag <- T
  if(num <= 1) {
    return()
  }else if(num == 2) {
    return (T)
    
  }else{
    for(i in 2:(num-1)) {
      if(num %% i == 0){
        flag = F
        break
      }
    }
  }
  return(flag)
}



P(4)
