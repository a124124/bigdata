

/* 동적인 부분(DB연동 없는) = 자바스크립트(함수형 언어, 인터프리터 언어)  */
name = prompt("이름이 뭐니", "홍길동");
document.write(name + ' ~Welcome <br>');  /* <br> = 개행*/
function chk() {
    if (frm.tel.value.length < 4) {
        alert("전화번호는 4자리 이상 입력해주세요");
        return false; /* submit 이벤트 제한 */

    }
}// JavaScript source code
