<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" value="Gestion des Questions"/>
<s:include value="../partials/header.jsp"/>

<s:div class="container">
  <h1>Gestionnaire de Proposition</h1>
  <hr/>
  <s:if test="hasActionErrors()">
    <p class="alert alert-danger">
      Une erreur est survenue lors de l'ajout. <br/>
      Veuillez verifier vos paramètres.
    </p>
  </s:if>

  <s:if test="hasActionMessages()">
    <div class="alert alert-success">
     <p>
       La propostion a été ajouter avec success !!!<br/>
       <s:if test="reponse.vrai">
         et elle est considéré comme vrai.
       </s:if>
       <s:else>
         et elle est considéré comme fausse.
       </s:else>
     </p>

      <p>
        <strong>
          <s:property value="reponse.question.contexte"/>
        </strong>
        <ul>
          <s:iterator value="reponseDAO.list(reponse.questionnaire.identifiant , reponse.question.identifiant)">
            <li><s:property value="proposition"/></li>
          </s:iterator>
        </ul>
      </p>
    </div>
  </s:if>

    <s:form action="ajouter_reponse">
      <div class="row">
        <div class="span8">
          <fieldset>
            <s:div class="control-group">
              <label class="control-label">Liste des questionnaires <span class="required">*</span></label>
              <s:div class="controls">
                <select name="reponse.questionnaire.identifiant" required="true" class="span4">
                  <s:iterator value="questionnaireDAO.list()">
                    <option value="<s:property value="identifiant"/>"><s:property value="libelle"/></option>
                  </s:iterator>
                </select>
              </s:div>
            </s:div>

            <s:div class="control-group">
              <label class="control-label">Liste des questions <span class="required">*</span></label>
              <s:div class="controls">
                <select name="reponse.question.identifiant" required="true" class="span4">
                  <s:iterator value="questionDAO.list()">
                    <option value="<s:property value="identifiant"/>"><s:property value="contexte"/></option>
                  </s:iterator>
                </select>
              </s:div>
            </s:div>
          </fieldset>
          </div>
        <div class="span8">
          <fieldset>
            <s:div class="control-group">
              <label class="control-label">Proposition : <span class="required">*</span></label>
              <s:div class="controls">
                <s:textfield name="reponse.proposition" required="true"  value="" class="span4" theme="simple" autocomplete="false" />
              </s:div>
            </s:div>

            <s:div class="control-group">
              <label class="control-label">Vrai <s:checkbox name="reponse.vrai" theme="simple"/></label>
            </s:div>
          </fieldset>
        </div>

      </div>
      <div class="row">
        <footer  class="form-actions">
          <button type="submit" class="btn btn-primary">Ajouter</button>
          <button type="reset" class="btn" >Effacer</button>
        </footer>
      </div>
    </s:form>
</s:div>

<s:include value="../partials/footer.jsp"/>