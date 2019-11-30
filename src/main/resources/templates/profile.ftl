<#import "parts/common.ftl" as c>

<@c.page "Профиль пользователя">
    <#include "parts/navbar.ftl">
<div class="container">
<h3>Управление пользователем:</h3>
<h5>${username}</h5>
    ${message?if_exists}
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Текущий пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="curPassword" id="CurPass" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Новый пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" id="Pass" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Повторите пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="repeatpassword" id="repeatPass" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email:</label>
            <div class="col-sm-6">
                <input type="email" name="email" class="form-control" placeholder="some@gmail.com" value="${email!''}"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</div>
</@c.page>
