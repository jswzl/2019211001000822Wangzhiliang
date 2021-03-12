<%--
  Created by IntelliJ IDEA.
  User: 王志良
  Date: 2021-03-09
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./me.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <title>Title</title>
</head>
<body class="login-bg">
<%--    <a href="./index.jsp">get index page</a>--%>
<br><br><br><br><br>
<div class="m-container-small m-padded-tb-massive disabled" style="max-width: 30em !important; margin-left: 530px">
    <div class="ui container">
        <div class="ui middle aligned center aligned grid">
            <div class="column">
                <h2 class="ui teal image header">
                    <div class="content">
                        New User Registration!
                    </div>
                </h2>
                <form class="ui large form" method="post">
                    <div class="ui  segment">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text" name="name" placeholder="姓名">
                            </div>
                        </div>

                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password" name="password" placeholder="password">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="envelope icon"></i>
                                <input type="text" name="email" placeholder="email">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">Gender:
                                <label><input type="radio" name="sex" value="Male">Male</label>
                                <label><input type="radio" name="sex" value="FeMale">FeMale</label>
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="calendar alternate icon"></i>
                                <input type="text" name="date" placeholder="Date of birth(yyyy-mm-dd)">
                            </div>
                        </div>
                        <button class="ui fluid large teal submit button">Register</button>
                        <div class="ui error mini message"></div>
                    </div>



                </form>
            </div>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
<script>
    $('.ui.form').form({
        fields : {
            name : {
                identifier: 'name',
                rules: [{
                    type : 'empty',
                    prompt: '请输入用户名'
                }]
            },
            password : {
                identifier: 'password',
                rules: [{
                    type : 'empty',
                    prompt: '请输入密码'
                }]
            },
            email : {
                identifier: 'email',
                rules: [{
                    type : 'empty',
                    prompt: '请输入邮箱'
                }]
            },
            date : {
                identifier: 'date',
                rules: [{
                    type : 'empty',
                    prompt: '请输入生日'
                }]
            }
        }
    });
</script>
</body>
</html>
