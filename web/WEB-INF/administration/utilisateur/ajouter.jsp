
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" var="titre" value="Gestions des Utilisateurs "/>
<s:include value="../partials/header.jsp" />

<s:form action="ajouter_utilisateur" class="form-horizontal" method="post">
  <div class="container">

    <div class="alert alert-block alert-info">
      <p>
         Ce formulaire vous permet d'inscrire un utilisateur !!!
      </p>
    </div>
    <s:if test="hasErrors()">
      <div class="alert alert-block alert-danger">
        <p>
          Les parametres saisie sont incorrect !!! <br/>
          Veuillez corriger vos erreurs.
        </p>
      </div>
    </s:if>
    <s:if test="hasActionMessages()">
      <div class="alert alert-block alert-success">
        <p>
         Inscription effectuer avec success !!!
        </p>
      </div>
    </s:if>
    <div class="row">
      <div id="acct-password-row" class="span7">
        <fieldset>
          <legend>Identifiant de l'Utilisateur</legend><br>
          <div class="control-group ">
            <label class="control-label">Identifiant :<span class="required">*</span></label>
            <div class="controls">

              <s:textfield name="utilisateur.identifiant" value="" pattern="^[0-9]+$" required="true" class="span4" theme="simple" autocomplete="false" />
            </div>
          </div>
          <div class="control-group ">
            <label class="control-label">Mot de passe : <span class="required">*</span></label>
            <div class="controls">
              <s:password name="utilisateur.password" value="" required="true" class="span4" theme="simple" autocomplete="false" />
            </div>
          </div>
        </fieldset>
      </div>
      <div id="acct-verify-row" class="span9">
        <fieldset>
          <legend>Information de l'Utilisateur</legend>
          <div class="control-group">

            <div class="control-group ">
              <label class="control-label">Nom :<span class="required">*</span></label>
              <div class="controls">
                <s:textfield name="utilisateur.nom" required="true" value="" class="span4" theme="simple" autocomplete="false" />
              </div>
            </div>
            <div class="control-group ">
              <label class="control-label">Prenom : <span class="required">*</span></label>
              <div class="controls">
                <s:textfield name="utilisateur.prenom" required="true"  value="" class="span4" theme="simple" autocomplete="false" />
              </div>
            </div>
          </div>
        </fieldset>
      </div>
    </div>
    <footer  class="form-actions">
      <button type="submit" class="btn btn-primary">Inscrire</button>
      <button type="reset" class="btn" >Effacer</button>
    </footer>
  </div>
</s:form>
<div class="container">
<div class="span12">
  <div id="Person-1" class="box" style="display: block;">
    <div class="box-header">
      <i class="icon-user icon-large"></i>
      <h5>Liste des utilisateurs</h5>

    </div>
    <div class="box-content box-table">
      <table class="table table-hover tablesorter">
        <thead>
        <tr>
          <th>Identifiant</th>
          <th>Nom</th>
          <th>Prenom</th>
          <th>Option</th>

        </tr>
        </thead>
        <tbody>
        <s:iterator value="utilisateurDAO.list()" >
          <tr>
            <td><s:property value="identifiant"/></td>
            <td><s:property value="nom"/></td>
            <td><s:property value="prenom"/></td>
            <td>
              <s:form action="supprimer_utilisateur" method="post">
                <s:textfield type="hidden" name="utilisateur.identifiant" value="%{identifiant}" theme="simple"/>
                <s:submit value="Supprimer" class="btn btn-danger" theme="simple"/>
              </s:form></td>
          </tr>
        </s:iterator>
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>

<s:include value="../partials/footer.jsp"/>