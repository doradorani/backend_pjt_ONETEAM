function onInputCreateAccountForm(){
    console.log("onInputCreateAccountForm() CALLED!!!");


    this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
}

function createAccountForm() {
    console.log("createAccountForm() CALLED!!!");

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
    } else if(form.class.value == ''){
        alert("반을 입력해주세요!");
        form.class.focus();
    } else if(form.eigenNo.value == ''){
        alert("번호를 입력해주세요!");
        form.eigenNo.focus();
    } else {
        let phone = form.phone1.value + form.phone2.value + form.phone3.value;
        let mail = form.mail1.value + form.mail2.value + form.phone3.value;

        form.submit();
    }

}