####################################
##### 14장. 지도 시각화   ###
####################################


#### 1. 정적 이미지 지도 시각화 ####

install.packages('ggmap')
library(ggmap)
?get_stamenmap
seoul <- c(left=126.77, right=127.17, top=37.70, bottom=37.4)

map <- get_stamenmap(seoul, zoom=12, maptype = 'terrain')

ggmap(map)


pop <- read.csv('inData/population201901.csv')
View(pop)
str(pop)

library(stringr)

region <- pop$'지역명'
region

lon <- pop$LON #위도
lat <- pop$LAT #경도
tot_pop <- as.numeric(str_replace_all(pop$총인구수,',','')) # 총인구수 

# 지역명, 위도, 경도, 인구수를 데이터프레임으로 생성

df <- data.frame(region, lon, lat, tot_pop)
df <- df[1:17,]
df

# 정적 지도 이미지 가져오기

daegu <- c(left=123.4423013, right=131.601145, top=38.8714354, bottom=32.828306)
map <- get_stamenmap(daegu, zoom=7, maptype = 'terrain')
layer1 <- ggmap(map)
layer1
layer2 <- layer1 + geom_point(data=df, aes(x=lon, y=lat, color=factor(tot_pop),
                                           size=factor(tot_pop)))
layer2
layer3 <- layer2 + geom_text(data=df,aes(x=lon,y=lat,label=region),size=4)
layer3


#### 2. ggiraphExtra 패키지를 이용한 인터렉티브한 지도 시각화 ####
## 2.1 미국 주별 각력 범죄율 시각화
# (1) 패키지 준비
install.packages('ggiraphExtra') # 지도시각화를 위한 패키지
install.packages('mapproj') # ggChoropleth 함수 사용을 위한 패키지
install.packages('maps') # 지도 정보 이용
library(kormaps2014)
library(ggiraphExtra)
library(mapproj)
library(maps)
library(tibble) # 행이름을 변수로 하기 위한 작업
library(ggplot2)
head(USArrests)
.libPaths()

# (2) rownames 을 변수로

crime <- rownames_to_column(USArrests, var='state')
head(crime,3)

map_data('state')
crime$state <- tolower(crime$state)
head(crime,3)

# (3) 미국 지도 주의 위도 경도 가져오기

state_map <- map_data('state')
View(state_map)


# (4) 지도 시각화
ggChoropleth(data=crime, # 지도에 표현할 데이터
             aes(fill=Murder, # 지도에 채워질 변수
                 map_id=state), # 지도에 나타날 지역
             map= state_map, #위도 경도 데이터
             interactive= T)



## 2.2 대한민국 시도별 인구 구분도 시각화

install.packages('stringi')
install.packages('devtools')
devtools::install_github('cardiomoon/kormaps2014')

library(kormaps2014)
head(kormap1)
View(kormap1) # 시도별 위,경도 
View(korpop1) # 2015년 센서스 데이터
# 에러나면 Rtools 4.0을 설치 (cran.r-project.org)


# korpop1$name : UTF-8 을 CP494로 변환
library(stringi)
str(changeCode(korpop1))
head(korpop1)
head(kormap1,2) # 2015 년 센서스 데이터(시도별)
str(korpop1)
str(changeCode(korpop1))

colnames(korpop1)
library(dplyr)
korpop1 <- rename(korpop1, pop=총인구_명,
                  name=행정구역별_읍면동)

head(korpop1[,c('name','pop','code')])


korpop1$name <- iconv(korpop1$name, 'UTF-8','CP949')


head(korpop1[,c('name','pop','code')])



# 지도 시각화

ggChoropleth(data=korpop1, #지도에 표현할 데이터 셋
             aes(fill=pop, #지도에 채워질 변수
                 map_id=code,
                 tooltip=name), #지역 구분 변수
             map=kormap1, #위도 경도 지도 데이터
             interactive = T)
