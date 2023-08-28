function filterKey(){
    console.log("filterKey() CALLED!!!");

    let filterNum = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');

    this.value(filterNum);
}

function createAccountConfirm() {
    console.log("createAccountConfirm() CALLED!!!");

    let form = document.createAccountForm;

    if(form.id.value == ''){
        alert("아이디를 입력해주세요!");
        form.id.focus();
    } else if(form.password.value == ''){
        alert("비밀번호를 입력해주세요!");
        form.password.focus();
    } else if(form.password_again.value == ''){
        alert("비밀번호 확인을 다시 입력해주세요!");
        form.password_again.focus();
    } else if(form.password.value != form.password_again.value){
        alert("비밀번호와 비밀번호 확인이 맞지 않습니다.");
        form.password.focus();
    } else if(form.name.value == ''){
        alert("이름을 입력해주세요!");
        form.name.focus();
    } else if(form.gender.value == ''){
        alert("성별을 선택해주세요!");
        form.gender.focus();
    } else if(form.phone1.value == ''){
        alert("핸드폰 번호를 입력해주세요!");
        form.phone1.focus();
    } else if(form.phone2.value == ''){
        alert("핸드폰 번호를 입력해주세요!");
        form.phone2.focus();
    } else if(form.phone3.value == ''){
        alert("핸드폰 번호를 입력해주세요!");
        form.phone3.focus();
    } else if(form.mail1.value == ''){
        alert("메일을 입력해주세요!");
        form.mail1.focus();
    } else if(form.mail2.value == ''){
        alert("도메인을 입력해주세요!");
        form.mail2.focus();
    } else if(form.schoolName.value == ''){
        alert("학교 이름을 선택해주세요!");
        form.schoolName.focus();
    } else if(form.grade.value == ''){
        alert("학년을 선택해주세요!");
        form.grade.focus();
    } else if(form.classNo.value == ''){
        alert("반을 입력해주세요!");
        form.class.focus();
    } else if(form.eigenNo.value == ''){
        alert("번호를 입력해주세요!");
        form.eigenNo.focus();
    } else if(form.address.value == ''){
        alert("주소를 입력해주세요!");
        form.address.focus();
    } else {
        form.phone.value = (form.phone1.value + form.phone2.value + form.phone3.value);
        form.mail.value =(form.mail1.value + '@'+ form.mail2.value);

        form.submit();
    }

}