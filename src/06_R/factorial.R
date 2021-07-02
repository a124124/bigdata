################# factorial #####################

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