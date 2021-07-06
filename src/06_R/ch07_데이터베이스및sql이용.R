###################################
##### 7장. 데이터베이스 이용및 sql이용  
##################################

  # SQL로 데이터프레임이나 DB(oracle, mySql)테이블 이용 




rm(list=ls(all.names=T))

#### 1. SQL 문으로 데이터 프레임 처리 ####

install.packages('sqldf')

library(sqldf) # sqldf() 함수를 통해 데이터프레임을 DB 테이블처럼 사용


sqldf("select * from iris")

# 중복행 제거하면 한행만 출력
sqldf("select distinct Species from iris")


# 행 제한 조건(setosa 종만 출력)
sqldf("select * from iris where Species=='setosa'")
iris[iris$Species =='setosa',]

iris %>% 
  filter(Species == 'setosa')

# 컬럼에 .이 들어갈 경우
ex <- sqldf("select `sepal.length`, species from iris")



str(iris)
str(ex)

# 종별 sepal.length, sepal.width 
library(doBy)
summaryBy(Sepal.Length+Sepal.Width~Species, data=iris, FUN=mean)
sqldf("select Species, avg(`Sepal.Length`), avg(`Sepal.Width`) from iris group by Species having avg(`Sepal.Length`)>6")

# iris 를 Sepal.Length 기준으로 내림차순 정렬해서 11~20만 출력


sqldf("select * from iris order by `Sepal.Length` DESC limit 10,5")



#### 2. 오라클 데이터 베이스 연결 ####
  #사전 작업: ojbd6.jar 를 이용하므로 자바설치 후 환경변수 설정(JAVA_HOME)

getwd() # 작업 디렉토리에 ojbd6.jar 를 복사해둔다.



# 패키지 설치 및 로드 : RJDBC


install.packages("RJDBC")

require(RJDBC)


# 드라이버 클래스 로드

drv <- JDBC("oracle.jdbc.driver.OracleDriver", classPath = "ojdbc6.jar")
drv

# 데이터 베이스 연결 
conn <- dbConnect(drv, "jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger")
conn

# SQL 문 전송 + 결과 받기

# 1번 방법
rs <- dbSendQuery(conn, "select * from emp")
emp <- fetch(rs, n=-1)


emp
class(emp)
head(emp)


# SQL

# 2번 방법

dept <- dbGetQuery(conn, 'select * from dept')
dept
str(dept)
dept[dept$DEPTNO<30,]

# 데이터 연결 해제

dbDisconnect(conn)

# 드라이버언로드 : DB연결해제 자동으로 언로드됨

dbUnloadDriver(drv)


# DB데이터 수정
dbSendUpdate(conn, "insert into dept values(50,'it','Seoul')")
dbSendUpdate(conn, "update dept set loc='busan' where deptno=50")
dbSendUpdate(conn, "delete from dept where deptno=50")


# RJDBC 패키지 언로드 
detach("package:RJDBC")




#### 3. MySQL 데이터 베이스 연결 ####

  #사전 작업 : 외부에서 엑세스 허용 
install.packages("RMySQL")

# ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password by 'mysql';
require(RMySQL)
drv <- dbDriver("MySQL")
drv

# 데이터베이스 연결

conn <- dbConnect(drv, host="127.0.0.1", dbname="kimdb",user="root",password="mysql")
conn


# SQL 전송 + 결과 받기 