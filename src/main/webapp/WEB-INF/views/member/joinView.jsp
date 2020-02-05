<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp" %>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="/"><b>Sejong-Track</b> Join</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Register a new membership</p>

        <form id="joinForm" action="/memberJoin" method="post" onsubmit="return totalCheck()">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="id" required placeholder="Id">
                <span class="glyphicon glyphicon-eye-open form-control-feedback"></span>
                <div class="row" style="margin: 6px 0px">
                    <div class="col-xs-8"><span id="idCheckRes"></span></div>
                    <div class="col-xs-4">
                        <input type="button" id="jButton" class="btn btn-block btn-default btn-flat" value="중복확인">
                    </div>
                </div>
            </div>


            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="name" required placeholder="Full name">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" name="email" required placeholder="Email">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" required placeholder="Password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="pwRe" required placeholder="Retype password">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                <div id="pwCheckRes"></div>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> I agree to the <a href="#">terms</a>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="${path}/loginView" class="text-center">I already have a membership</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

</body>
</html>

<script type="text/javascript">

    var idRes = false;
    var pwRes;
    var IsjButtonClicked = false;

    //아이디 중복확인 체킹
    function idCheck() {
        var id = $('input[name=id]').val();

        if (id == "") {
            $('#idCheckRes').css("color", 'red');
            $('#idCheckRes').html("아이디를 입력해주세요.");
            idRes = false;
        } else {
            $.ajax({
                url: '/memberExist',
                data: {"id": id},
                dataType: 'text',
                type: 'POST',
                async: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
                },
                success: function (data) {
                    if (data == "No") {
                        $('#idCheckRes').css("color", 'green');
                        $('#idCheckRes').html("사용가능한 아이디입니다.");
                        idRes = true;
                    } else {
                        $('#idCheckRes').css("color", 'red');
                        $('#idCheckRes').html("이미 존재하는 아이디입니다.");
                        idRes = false;
                    }
                },
                error: function (error) {
                    console.log(error);
                    idRes = false;
                }
            });
        }
    }

    $('input[name=id]').change(function () {
        idRes = false;
        IsjButtonClicked = false
    });

    $('#jButton').click(function () {
        IsjButtonClicked = true;
        idCheck();
    });


    //비밀번호 재확인 체킹
    function pwCorrect() {

        $("input[name=password]").keyup(function () {
            if ($("input[name=password]").val() == $("input[name=pwRe]").val()) {
                $("#pwCheckRes").html("비밀번호가 일치합니다.");
                pwRes = true;

            } else {
                $("#pwCheckRes").html("비밀번호가 일치하지 않습니다.");
                pwRes = false;
            }
        });

        $("input[name=pwRe]").keyup(function () {
            if ($("input[name=password]").val() == $("input[name=pwRe]").val()) {
                $("#pwCheckRes").html("비밀번호가 일치합니다.");
                pwRes = true;

            } else {
                $("#pwCheckRes").html("비밀번호가 일치하지 않습니다.");
                pwRes = false;

            }
        });
    }

    pwCorrect();

    //submit할 때 체킹
    function totalCheck() {
        if (IsjButtonClicked == false) {
            alert(" 중복확인을 해주세요 ");
        }
        return IsjButtonClicked && idRes && pwRes;
    }

    $('input').iCheck({ //AdminLTE 회원가입 테마 jquery
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });
</script>
