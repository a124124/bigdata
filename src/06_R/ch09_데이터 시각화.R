####################################
##### 9장. 데이터 시각화 ###
####################################


#### 1. 시각화 개요 : 원본데이터나 분석된 결과 데이터를 그래프로 표현.

## 1.1 R의 그래픽 시스템

# (1) base graphics system : 전통적인 함수 이용
    # 그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 노력이 필요함

# (2) grid graphic system - base graphics system 의 한계 극복 위해 만든 패키지(ggplot2)
    # 유연한 그래프 환경 제공



# ex. 
plot(mtcars$wt, mtcars$mpg) # 고수준 그래프 함수 (실행할때마다 새롭게 그림)
boxplot(mtcars$mpg)

fit <- lm(mtcars$mpg ~ mtcars$wt)
fit


abline(fit, col="red") # 저수준 그래프 함수( 그래프가 있으면 위에 덧그림)

library(ggplot2)
ggplot(data = mtcars, aes(x=wt, y=mpg)) + 
  geom_point(col='blue',pch=2) + labs(title='첫 산점도') + geom_smooth(method='lm')


ggplot(data=iris, aes(x=Species, y=Sepal.Length)) + geom_boxplot(fill='red')



## 1.2 그래프 함수
  # 고수준 함수 : plot barplot boxplot hist pie ...
      # 그래프 함수 호출할 때마다 새로운 그래프를 그림
  # 저수준 함수 : lines abline(회귀라인) point 
      # 그래프가 있으면 그 위에 덧그림


## 1.3 그래프 파라미터 : 그래프를 그리는 함수들은 다양한 파라미터가 존재
      # par() 함수를 통해 변경


# (1) par() : 그래프를 조정하거나 특성을 지정 ex.bty(그래프 박스 우형), 선굵기, 색상..
?par

cars
plot(cars)

oldcar <- par(bty='L') # 파라미터 지정전 객체
plot(iris)
plot(cars)
par(oldcar)
plot(cars,)
?plot

plot(cars, xlab='x label',ylab='y label', main='제목')


fit <- lm(dist ~ speed, data=cars)
abline(fit,col='red', lwd=4, lty='dashed')

colors()


# col : 1=black, 2=red, 3=green 등


# par 함수의 다른 파라미터 사용 예

x <- 1:100
y1 <- rnorm(100) # 평균이 0이고 표준편차가 1인 수 100개 추출 (표준정규분포)
y2 <- rnorm(100)+100 # 평균이 100이고 표준편차가 1인 수 100개 추출
oldpar <- par(mar=c(5,5,5,5)) # 그래프 여백 (하,좌,상,우)
?plot

  #xlim, ylim : x, y축 눈금 조정
  # yaxt : y축 눈금 없애기
  # bty: 그래프 박스 type: o L 7 ] C

plot(x,y1, pch=23, type='b', col='red', bg='pink', ylim=c(-8,2), yaxt='n', bty='n', ylab='')



axis(side=2, at=c(-2,0,2), col='red') # side : 하 좌 상 우   at: 축이 그려질 위치

mtext('red line(y1)', side=2, line=2, at=0, col=2)


par(new=T)
plot(x,y2,pch=20, type='b', col='blue', yaxt='n', ylim=c(98,108), ylab='',bty='n')

axis(side=4, at=c(98,100,102), col='blue')

mtext('blue line(y2)', side=4, line=2, at=100, col='blue')

par(oldpar)


#### 2. 고수준 그래프 함수 (base graphic system)

## 2.1 plot : type에 따라 여려 유형의 그래프를 그림. 산점도 함수

# 3행 2열로 그래프 영역


oldpar <- par(mfrow=c(2,3))

plot(cars, type='p', main='p 타입')

plot(cars, type='l', main='l 타입')

plot(cars, type='b', main='b 타입')
plot(cars, type='s', main='s 타입')
plot(cars, type='n', main='n 타입')
plot(cars, type='o', main='o 타입')



par(oldpar)
plot(cars, main='speed and stopping distance of cars', xlab='speed(mph)', ylab='stopping distance(ft)', las=1)

  #las 축눈금라벨방향 0 축과평행 1 가로 2 수직 3 세로


?par


## 2.2 barplot : 막대그래프 

VADeaths

datasets::VADeaths
class(VADeaths)
VADeaths

rownames(VADeaths)


barplot(VADeaths, main='버지니아 사망률', font=2, border='red',legend=rownames(VADeaths),density=50, angle=c(10,30,50,70,120),
        col = c(35,76,3,46,475))

  #legend : 오른쪽 상단 범례
  #density : 막대그래프 안에 칠할 선 수
  #angle : 빗금 각도


barplot(VADeaths, main='버지니아 사망률',font=2, border='red',legend=rownames(VADeaths),density=60,angle=c(10,30,45,60,100),beside=T, col=rainbow(5))

  #beside = TRUE : 막대 선분을 분리

install.packages('RColorBrewer')
install.packages("RColorBrewer")
library(RColorBrewer)
display.brewer.all()
pal <- brewer.pal(5, "Set1")
barplot(VADeaths, main='버지니아 사망률',font=2, border='red',legend=rownames(VADeaths),density=60,angle=c(10,30,45,60,100),beside=T, col=pal)



## 2.3 boxplot : 상자 그림(상자 도표, 사분위수 그래프)

datasets::InsectSprays

class(InsectSprays)

names(InsectSprays) <- c('cnt','spray')
InsectSprays
rm(InsectSprays)
head(InsectSprays)

boxplot(InsectSprays$count)
boxplot(InsectSprays$count~InsectSprays$spray)
boxplot(count~spray, data=InsectSprays, col=pal)


tapply(InsectSprays$count, InsectSprays$spray, median)
by(InsectSprays$count, InsectSprays$spray, summary)
tapply(InsectSprays$count, InsectSprays$spray, summary)


## 2.4 hist 히스토그램( 도수분포표 - 연속된데이터의 도수분포)

x <- c(1,1,2,2,2,3,4,4,4,5,5)

hist(x)
h <- hist(x, breaks=c(0.5,1.5,2.5,3.5,4.5,5.5), ylim=c(0,3.5))
h

text(h$mids, h$counts, paste(h$counts, '개', sep=''),adj=c(0,-1), col='red')

islands # 1만 평방마일을 초과하는 주요 대륙 넓이 정보

str(islands)  
class(islands)
is.vector(islands)
hist(islands)
hist(sqrt(islands), breaks= c(2, 30, 70, 100, 140))
?hist


set.seed(14)
x<-rnorm(1000) # 평균 0이고 표준편차가 1인 데이터 10개
hist(x)

## 2.5 pie
x <- c(20,30,30,20,15,5)
pie.lang <- x/sum(x)
pie.lang

names(pie.lang) <- c('c','R','Oracle','Java','Python','Hadoop')

pie(pie.lang, clockwise = TRUE, col=rainbow(6))   # 반시계방향 

## 2.6 mosaicplot : 배열 형식의 표를 이용해 모자이크 플룻 출력

Titanic

class(Titanic)
mosaicplot(~Sex+Age+Survived, data=Titanic, color=T)



#### 3. 저수준 그래픽 함수 ####

## 3.1 points

plot(-4:4, -4:4, type='n')
?par
points(rnorm(100), rnorm(100), pch=8, col='brown')


## 3.2 lines : 선
cars
head(cars,10)
plot(cars, main='속도와 제동거리와의 관계', pch=20)

fit <- lm(dist ~ speed, cars)
fit

lines(cars$speed, cars$speed*3.932-17.579, col='blue',lty='dashed',lwd=2)

## 3.3 abline : 회귀식선 
abline(fit, col='red', lwd=4)


## 3.4 text(x,y,출력할 텍스트, 그외 옵션)

plot(-1:1,-1:1,type='n',xlab='X')

points(0,0, pch=3, cex=4, lwd=3)

text(0,0,'hello')
text(0,0,'red',col='red',font=2,cex=3,adj=c(0,0))
text(0,0,'blue',col='blue',font=2,cex=3,adj=c(1,0))
text(0,0,'green',col='green',font=2,cex=3,adj=c(1,1))
text(0,0,'purple',col='purple',font=2,cex=3,adj=c(0,1))



# 수식 출력

plot(1:5, 1:5, type='n')
text(3,3,"a",adj=c(0,0),col='red')
text(1.5,4,expression(hat(beta)==(X^t)*X ^ {-1} * X^t*y, adj=c(0,0)))



#### 4. ggplot2 패키지 함수

install.packages('ggplot2')
library(ggplot2)

# 1. 그래프 초기화 하는 ggpolt - 그 자체로는 그래프 표현 x
# 2. 그래프의 결과물에 대응하는 geom함수
# 3. 부가 요소 추가 함수
# + 기호를 이용해서 함수들을 연결하는 방식으로 그래프 생성

# ggplot(data, aes(x=, y=)) + geom함수(어떤 그래프를 그릴지) + labs(제목, x축,y축 label, 서브제목, 출처)
#  + scale함수() + theme() +coord_cartesian() 등등

ggplot(data=mtcars, aes(x=wt, y=mpg)) + geom_point(aes(size=wt, col=cyl)) +
   labs(title='wt & mpg', subtitle='(차량무게와 연비와의 관계)',   
         x= 'weight(1,000lbs)', y='Fuel consumption(mpg)',caption='source:mpg datasets') +
  geom_smooth()
iris                                                                              
## 4.1 산점도, 적합도
# x축에 Sepal.Length, y축에 Sepal.Width 의 산점도(점의 색은 종에 따라 다르게)

ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width)) +
  geom_point(aes(col=Species)) +
  scale_color_manual(values = c('black','red','orange')) +
  labs(title='iris 데이터의 산점도',
       x = '꽃잎 길이',y='꽃잎 넓이') +
  coord_cartesian(ylim = c(0, 2.25)) +
  geom_smooth()



#airquality$Ozone , airquality$Solar.R 과의 관계를 산점도(월별산점도 색상을 다르게)

table(airquality$Month)
str(airquality$Month)

ggplot(data = airquality, aes(x=Solar.R, y=Ozone)) + geom_point(aes(col=Month))

airquality$Month <- as.factor(airquality$Month)
  


# mtcars 데이터의 wt, mpg
ggplot(mtcars, aes(x=wt, y=mpg)) + geom_point(shape=25, color='blue',bg='red',size=2, stroke=2) +
  geom_smooth(method='lm', col='red',lwd=1,lty='dashed') +
  geom_text(label=rownames(mtcars), hjust=0, vjust=0, nudge_y = 0.5) +
  labs(title='차량 무게와 연비와의 관계', subtitle='부제목', x='차량 무게(1,000lbs)', y='연비',caption='출처 : datasets::mtcars')

head(mtcars)
rownames(mtcars) <- 1:NROW(mtcars)
rownames(mtcars)
mtcars
rm(mtcars)

## 히스토그램 : 연속형 자료형에서 도수분포표(범주형 도수분포는 불가)

mtcars$mpg
cat(min(mtcars$mpg),max(mtcars$mpg))
ggplot(mtcars, aes(x=mpg))+
  geom_histogram()

# cyl 별로 히스토그램

table(mtcars$cyl)
stR(mtcars$cyl)

ggplot(mtcars, aes(x=mpg)) + geom_histogram() + facet_grid(cyl~.)

mtcars$cyl <- factor(mtcars$cyl, levels=c(4,6,8), labels=c('4 cyl','6 cyl','8 cyl'))

as.integer(mtcars$cyl)

ggplot(mtcars, aes(x=cyl)) +
  geom_histogram()       # 이건 원래 에러가 남


# ggplot2::mpg 의 displ의 도수분포표(clss에 따라 색상을 달리)

str(mpg$displ)

ggplot(data=mpg, aes(x=displ)) +
  geom_histogram(bins=20, aes(fill=class), binwidth = 0.2) +
  theme(legend.position = 'bottom',
        axis.text.x = element_text(color='red', size=5),
        axis.line = element_line(color='black',size=1),
        axis.text.y = element_blank(),
        panel.background = element_rect(fill='lightblue')) 

# fill : 색상  col :테두리 색상상
# bins: bins의 갯수를 지정하지 않으면 30 



## 4.3 상자도표(boxplot)

boxplot(iris$Sepal.Length)$stat

#전체 데이터에 대해 sepal.legnth의 boxplot
ggplot(iris, aes(y=Sepal.Length)) +
  geom_boxplot()


# 종별 sepal.length 의 boxplot

ggplot(iris, aes(x=Species, y=Sepal.Length, fill=Species, col=Species)) +
  geom_boxplot() + 
  scale_fill_manual(values=pal)



# gapminder::gapminder 대륙별 gdp의 차이가 있는지 boxplot

install.packages("gapminder")
library(gapminder)
dim(gapminder)
gapminder = gapminder::gapminder
head(gapminder)

temp = gapminder[gapminder$continent == 'Asia',]
edit(temp)


tapply(gapminder$gdpPercap, gapminder$continent, FUN=median)


ggplot(gapminder, aes(x=continent, y=gdpPercap)) +
  geom_boxplot(aes(fill=continent)) +
  coord_cartesian(ylim=c(0,90000)) +
  theme(axis.text.x = element_text(angle=45, vjust=0.6))

# car::Salaries 에서 교후의 직급(rank)별 연봉(salary)의 boxplot

install.packages('car')
library(car)
dim(Salaries)
head(Salaries)

ggplot(Salaries, aes(x=rank, y=salary, col=rank)) + geom_boxplot(fill='lightyellow') +
  geom_point(position = 'jitter', alpha=0.3, color='brown', pch=20) +
  geom_rug(sides='l') 

  
#notch = TRUE : 중위수에 대해 95% 신뢰구간을 표현


# mtcars 데이터 cyl개수에 따른 연비mpg의 95%중위수신뢰구간을 boxplot으로 시각화하기

ggplot(mtcars, aes(x=cyl, y=mpg)) + geom_boxplot(notch = T)



dim(mtcars)


## 4.4 바이올린 도표 : boxplot 과 밀도도표를 합쳐

#
singer <- lattice::singer
singer

ggplot(singer, aes(x=voice.part, y=height)) + geom_violin(fill='honeydew2') +
  geom_boxplot(width=0.3, fill='green') + geom_point(position = 'jitter',alpha=0.6, col='orange')


## 4.5 밀도도표

rm(mtcars)
str(mtcars)

# 실린더수(cyl)에 따른 연비를 밀도도표
mtcars$cyl <- factor(mtcars$cyl, levels=c(4,6,8), labels=c('4 cyl','6 cyl','8 cyl'))

ggplot(mtcars, aes(x=mpg, fill=cyl)) +
  geom_density() + theme(legend.position = c(0.7,0.8))



## 4.7 추세선( 시계열에서 데이터의 흐름 표현)

dim(economics)
head(economics)

# 시간에 따른 실업률

ggplot(economics, aes(x=date, y=unemploy)) + geom_line() + geom_smooth(method='lm')


## 4.7 막대 그래프( geom_bar(), geom_col())
  # 도수 분포표 시각화 : 히스토그램(연속데이터), 막대그래프(범주형데이터)
    # 히스토그램: 연속된 자료를 계급으로 나누어 계급별 도수
    # 막대 그래프: 범주형 데이터의 빈도를 나타냄




## 4.8 그래프를 파일에 저장 

# (1) basic graph, ggplot 패키지 모두 저장
jpeg('iris.jpg', width=400, height=400)
boxplot(iris$Sepal.Length)
dev.off()

getwd()


png('outData/iris.png', width=300, height = 150)
ggplot(iris, aes(x=Petal.Length, y=Petal.Width)) + geom_point() + facet_wrap(~ Species)
dev.off()


# (2) ggplot2 패키지 그래프 함수에서만 저장할 수 있는 방법

ggplot(iris, aes(x=Petal.Length, y=Petal.Width, col=Species)) + geom_point(aes(size=Petal.Width),pch=2)
ggsave('outData/iris.jpg')



## 4.9 ggplot2 에서 차트 분할 출력

install.packages('gridExtra')
library(gridExtra)

g1 <- ggplot(iris, aes(x=Petal.Width, y=Petal.Length)) + geom_point()
g1

g2 <- ggplot(iris, aes(x=Sepal.Width, y=Sepal.Length)) + geom_point()
g2

grid.arrange(g1, g2, ncol=2, nrow=1)


#### 5. 산점도 행렬

plot(iris[-5])
pairs(iris[-5], panel=panel.smooth)

library(ggplot2)
table(mpg$manufacturer)
ggplot(mpg, aes(x=manufacturer)) + geom_bar(stat='count') + theme(axis.text.x = element_text(angle = 45, vjust=0.7))

library(RColorBrewer)




ggplot(mpg, aes(x=displ)) +
  geom_histogram()



# 제조회사별 빈도그래프(class별 다른 색상으로)

ggplot(mpg, aes(x=manufacturer)) + geom_bar(col='red', aes(fill=class)) +
  labs(title = '제조회사별 class별 빈도',
       subtitle='(class별 분리)',
       x='제조회사',y='빈도수',
       caption='source:ggplot2::mpg') +
  theme(axis.text.x = element_text(angle = 45, vjust=0.7), legend.position = 'bottom') +
  scale_fill_manual(values = brewer.pal(7, 'Set1')) +
  scale_color_manual(values=brewer.pal(7,'Set3')) +
  coord_cartesian(ylim=c(0, 50))
length(unique(mpg$class))


# ggplot2::diamonds 데이터셋에서 절단품질(cut)별 빈도수
table(diamonds$cut)
dim(diamonds)
ggplot(diamonds, aes(x=cut)) +
  geom_bar(stat='count', aes(fill=cut))


# 품질 별 색상의 갯수
head(diamonds)

table(diamonds$cut, diamonds$color)


library(dplyr)
diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x=cut, y=n, fill=color)) +
  geom_bar(stat='identity', position='dodge')

# cut별 table 수를 시각화
table(diamonds$cut, diamonds$table)
         

diamonds %>% 
  group_by(cut, table) %>% 
  summarise(n= n()) %>% 
  group_by(cut) %>% 
  summarise(cnt = n()) %>% 
  ggplot(aes(x=cut, y=cnt, full=cut)) +
  geom_bar(stat='identity') +
  labs(title='다이아몬드 품질별 다이아몬드 상단 넓이 종류',
       subtitle='cut별 table수') +
  theme(legend.position = 'bottom',
        plot.title = element_text(hjust=.5),
        plot.subtitle = element_text(hjust=.5))

# cut별 table별 빈도수 시각화

diamonds %>% 
  group_by(cut, table) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x=table, y=n)) +
  geom_bar(stat='identity') +
  facet_wrap(~cut) + # cut별 시각화를 따로
  coord_cartesian(ylim=c(0,4000), xlim=c(50,80))




# 11.datasets::cars데이터 셋을 이용하여 속도에 대한 제동거리의 산점도와 적합도(신뢰구간
#  그래프)를 나타내시오(단, 속도가 5부터 20까지 제동거리 0부터 100까지만 그래프에 나타냄).


library(ggplot2)
ggplot(cars, aes(x=speed, y=dist)) + geom_point() + 
  coord_cartesian(ylim= c(0, 100), xlim=c(5, 20)) + geom_smooth(method='lm')



# 12.gapminder::gapminder 데이터 셋을 이용하여 1인당국내총생산에 대한 기대수명의 산점도를 대륙별 다른 색으로 나타내시오.

library(ggplot2)
head(gapminder)
ggplot(gapminder, aes(x=gdpPercap, y=lifeExp, color=continent)) + geom_point()


# 13. gapminder::gapminder 데이터 셋을 이용하여 기대 수명이 70을 초과하는 데이터에 대해 대륙별 데이터 개수


head(gapminder)
gapminder %>% 
  group_by(continent, lifeExp) %>% 
  summarise(n = n()) %>% 
  filter(lifeExp > 70) %>% 
  ggplot(aes(x=continent, y=n, fill=continent)) +
  geom_bar(stat='identity')


# 14. gapminder::gapminder 데이터 셋을 이용하여 기대수명이 70을 초과하는 데이터에 대해
# 대륙별 나라 갯수.
head(gapminder)




gapminder %>% 
  group_by(continent,country,lifeExp) %>% 
  filter(lifeExp >70) %>% 
  summarise(n = n()) %>%
  ggplot(aes(x=continent, y=n, fill=continent)) +
  geom_bar(stat='identity')
  

  

# 15. gapminder::gapminder 데이터 셋을 이용하여 대륙별 2007년도(저번에 이부분 뺌) 기대
# 수명의 사분위수를 시각화
head(gapminder)
gapminder %>% 
  group_by(continent,year) %>% 
  filter(year == 2007) %>% 
  ggplot(aes(x=continent, y=lifeExp, color=continent))+ 
  geom_boxplot()


# 16. gapminder::gapminder 데이터 셋을 이용하여 년도별로 gdp와 기대수명과의 관계를 산
# 점도를 그리고 대륙별 점의 색상을 달리 시각화

gapminder %>% 
  group_by(continent,year,gdpPercap,lifeExp) %>% 
  ggplot(aes(x=gdpPercap,y=lifeExp, color=continent))



# 17. gapminder::gapminder 데이터 셋에서 북한과 한국의 년도별 GDP 변화를 산점도로 시각
# 화하시오(북한:Korea, Dem. Rep. 한국:Korea, Rep. substr(str, start, end)함수 이용)

head(gapminder)
edit(gapminder)
gapminder %>% 
  group_by(continent,year,gdpPercap) %>% 
  filter(country=='Korea, Dem. Rep.' | country == 'Korea, Rep.') %>% 
  ggplot(aes(x=year,y=gdpPercap, col=country)) +
  geom_point(pch=1)


# 18. gapminder::gapminder 데이터 셋을 이용하여 한중일 4개국별 GDP 변화를 산점도와 추
# 세선으로 시각화 하시오.

gapminder %>% 
  group_by(continent,year,gdpPercap) %>% 
  filter(country=='Korea, Dem. Rep.' | country == 'Korea, Rep.' | country == 'Japan' | country == 'China') %>% 
  ggplot(aes(x=year,y=gdpPercap, col=country)) +
  geom_line()

# 19. gapminder::gapminder 데이터 셋에서 한중일 4개국별 인구변화 변화를 산점도와 추세선
# 으로 시각화 하시오(scale_y_continuous(labels = scales::comma)추가시 우측처럼)

gapminder %>% 
  group_by(continent,year,pop) %>% 
  filter(country=='Korea, Dem. Rep.' | country == 'Korea, Rep.' | country == 'Japan' | country == 'China') %>% 
  ggplot(aes(x=year,y=pop, col=country)) +
  geom_line()+
  scale_y_continuous(labels = scales::comma)

 
# 20. Ggplot2::economic 데이터 셋의 개인 저축률(psavert)가 시간에 따라 어떻게 변해 왔는
# 지 알아보려 한다. 시간에 따른 개인 저축률의 변화를 나타낸 시계열 그래프와 추세선을 시각
# 화하시오
head(economics)
ggplot(economics, aes(x=date, y=psavert)) +
  geom_line(col='red') + geom_smooth()


library(ggplot2)
data(economics, package = 'ggplot2')
economics = ggplot2::economics
head(economics)
ggplot(economics, aes(x=date, y=unemploy)) +
  geom_line()


install.packages('dygraphs')

library(dygraphs)
library(xts)

str(economics)

eco <- xts(economics$unemploy, order.by=economics$date)
head(eco)

dygraph(eco) %>% dyRangeSelector()

head(economics[,c('psavert','unemploy')])


# 여러값을 표현한 인터랙티브 시계열 그래프
eco_a <- xts(economics$unemploy, order.by = economics$date)
eco_b <- xts(economics$psavert, order.by = economics$date)
eco2 <- cbind(eco_a, eco_b)
head(eco2)

colnames(eco2) <- c('psavert','unemploy')
eco2
dygraph(eco2)
