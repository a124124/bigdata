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
library(ggiraphExtra)
library(mapproj)
library(maps)
library(tibble) # 행이름을 변수로 하기 위한 작업
head(USArrests)
.libPaths()
