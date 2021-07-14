####################################
##### 12장. 텍스트 마이닝  ###
####################################

# 문자로 된 비정형 텍스트 데이터로부터 가치있는 정보를 얻어내는 분석
  # 텍스트마이닝에서 가장 먼저 할 일은 형태소 분석

install.packages('rJava')
install.packages('memoise')
install.packages('KoNLP')  


# google 에 KoNLP 를 검색  CLAN 사이트 접속 , 아카이브 클릭, 최신버전 다운로드 후

# RStuio 우측 패키지 탭에서 수동으로 Install 하기 위해 필요한 패키지를 설치

install.packages('devtools')




install.packages('hash')
install.packages('tau')
install.packages('Sejong')
install.packages('RSQLite')

# 우측의 package에 KoNLP가 있는지 확인

.libPaths()

library(KoNLP)
useNIADic()
3useSejongDic()
extractNoun("대한민국의 영토는 한반도와 그 부속 도서로 한다")

extractNoun(c("대한민국의 영토는 한반도와 그 부속 도서로 한다",'즐거운 수요일이다'))



#### 1. 힙합 가사 텍스트 마이닝


## 1.1텍스트 로드
txt <- readLines('inData/hiphop.txt') # 비정형데이터

head(txt)
class(txt)
length(txt)
is.vector(txt)


## 1.2 특수문자 제거 (trim, 특수문자)

# gsub(oldStr, newStr, string) ; string의 oldstr을 newstr로 바꿈
# str_replace_all(string, oldStr, newStr) ; string에 oldStr을 newStr 로 바꿈


library(stringr)
trim = function(str){
  return(gsub('^\\s+|\\s+$','',str))
}
trim('          hhhollle               ') # 방탄 소년단

temp <- gsub('\\W',' ',txt)
txt[684]
temp[684:790]

txt <- str_replace_all(txt, '//W',' ')

table(temp==txt)

txt <- trim(txt)



## 1.3 명사 추출
nouns <- extractNoun(txt)
class(nouns)
length(nouns)
head(nouns)
unlist(nouns)

length(unlist(nouns))
table(unlist(nouns))
table(c('하나','하나','둘'))
wordcount <- table(unlist(nouns)) # 단어별 빈도표 생성
class(wordcount)
sort(wordcount, decreasing = T)


library(dplyr)
df_word <- as.data.frame(wordcount, stringsAsFactors = F)
head(df_word)

df_word <- rename(df_word, word=Var1, freq=Freq)
head(df_word)
df_word$word <- trim(df_word$word)

# 한글자 이상의 단어만 추출

df_word <- df_word %>% 
  filter(nchar(word)>1)
df_word <- filter(df_word, nchar(word)>1)

head(df_word)


# 자주 사용되는 단어 top 20 추출



top20 <- df_word[order(-df_word$freq),][1:20,]
top20

# 그래프 그리기 
library(ggplot2)

ggplot(top20, aes(x=word,y=freq))+ geom_col() +
  coord_flip()

ggplot(top20, aes(x=freq, y=reorder(word,freq)))+ geom_col() +
  geom_text(aes(label=freq, col='red'), nudge_x = 4)

df_word

# 워드 클라우드
  # 1) 비정형 text 데이터 확보
  # 2) 패키지 설치 및 로드(KoNLP, wordcloud)
  # 3) 확보된 text 데이터 읽어오기(벡터형태)
  # 4) 명사 추출
  # 5) 필요없는 데이터 삭제(특수문자, zz, ㅋㅋ 등)
  # 6) 워드 클라우드 생성 (dataFrame)
  # 7) wordcloud 함수 이용하여 워드클라우드 생성

install.packages('wordcloud')
library(wordcloud)
display.brewer.all()
pal <- brewer.pal(9,'Blues')[5:9]
pal

set.seed(1234) # 난수 생성 결과를 일치시키려고 시드값을 지정한다
round(runif(6, min=1, max=45))

# wordcloud 함수 에러 시 : install.packages('Rcpp')
?wordcloud
install.packages('Rcpp')
library(Rcpp)

wordcloud(words=df_word$word, #출력될 단어
          freq = df_word$freq, # 단어 출현 빈도
          min.freq = 2, # 최소 단어 빈도
          max.words = 200, # 표현될 최대 단어 수
          random.order = F, # 최빈 단어가 중앙에 배치
          rot.per = 0.1, # 회전 단어 비율
          scale = c(4,0.3), # 단어 크기와 범위
          colors=pal) # 단어 색상 


rm(list=ls(all.names=T))
library(KoNLP)
library(stringr)
library(dplyr)
library(ggplot2)
library(wordcloud)

twitter <- read.csv('inData/twitter.csv',
                    header=T,
                    stringsAsFactors = F,
                    fileEncoding = 'UTF-8')

View(twitter)
edit(twitter)

twitter$'내용'

# 한글 인식이 잘 안될수 있어서 열이름을 바꾼다

twitter <- rename(twitter, no=번호, id=계정이름, date=작성일, tw=내용)
View(twitter)


# 필요없는 문자 삭제

twitter$tw <- str_replace_all(twitter$tw, '\\W',' ')
twitter$tw <- str_replace_all(twitter$tw, '[ㄱ-ㅎ]+',' ')

View(twitter)

# 명사 추출
class(twitter$tw)
nouns <- extractNoun(twitter$tw)


# wordcount 생성
wordcount <- table(unlist(nouns))
head(sort(wordcount, decreasing = T))


length(unlist(nouns)) # 추출된 명사 갯수
length(wordcount) # 출현한 명사 갯수 (중복 제거된 수치)

df_word <- as.data.frame(wordcount, stringsAsFactors = F)
str(df_word)
names(df_word) <- c('word','freq')
df_word <- filter(df_word, nchar(word)>1)
head(df_word)

# 최빈 단어 top20 그래프

top20 <- head(df_word[order(-df_word$freq),],20)
ggplot(top20, aes(x=freq, y=reorder(word,freq))) +
  geom_col(stat='identity') +
  geom_text(aes(label=freq), hjust=1, col='blue',size=5)

# 워드클라우드

set.seed(1234)
pal <- brewer.pal(8,'Dark2')
wordcloud(words=df_word$word,
          freq=df_word$freq,
          min.freq = 5,
          max.words = 200,
          random.order = F, 
          rot.per= 0.1,
          scale=c(5,0.7),
          colors=pal)


# 글 게시 횟수가 150회 이상 트윗한 게시물에 대해 시각화

table(twitter$id)

idCount <- as.data.frame(table(twitter$id))
colnames(idCount) <- c('id','count')
head(idCount)

# left join 사용

twitter <- left_join(twitter, idCount)
View(tw1)
# 150회이상 트윗한 계정의 정보만 추출
tw1 <- subset(twitter, count>150)
View(tw1)
