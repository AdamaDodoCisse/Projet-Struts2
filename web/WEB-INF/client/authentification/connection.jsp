
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
  <s:include value="../partials/header.jsp" />

  <div class='container'>

        <div class="signin-row row">
          <div class="span4"></div>
          <div class="span8">
            <s:if test="hasErrors()" >
              <div class="alert alert-error">
                <p class="text text-error">Echec de la connection <strong>Identifiant</strong> ou <strong>Mot de passe incorrect</strong>!!</p>
              </div>
            </s:if>
            <div class="container-signin">
              <legend>Authentification</legend>
              <s:form action="connection" method="post" id='loginForm' class='form-signin' autocomplete='off'>
                <div class="form-inner">
                  <div class="input-prepend">

                    <span class="add-on"  rel="tooltip" data-placement="top"><i class="icon-lock"></i></span>
                    <s:textfield pattern="[0-9]+" name="utilisateur.identifiant" required="true" value="%{utilisateur.identifiant}" class="span4" theme="simple"/>

                  </div>

                  <div class="input-prepend">

                    <span class="add-on"><i class="icon-key"></i></span>
                    <s:textfield type="password" required="true" name="utilisateur.password" value="" class="form-control" theme="simple"/>
                  </div>
                  <label class="checkbox" for='remember_me'>Se souvenir de moi
                    <input type='checkbox' id='remember_me'
                            />
                  </label>
                </div>
                <footer class="signin-actions">
                  <input class="btn btn-primary" type='submit' id="submit" value='Se connecter'/>
                </footer>
              </s:form>
            </div>
          </div>
          <div class="span3"></div>
        </div>

  </div>

    </div>
  </div>

  <div id="spinner" class="spinner" style="display:none;">
    Loading&hellip;
  </div>


  <s:include value="../partials/footer.jsp" />