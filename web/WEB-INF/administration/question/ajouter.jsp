<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 04/01/2015
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="titre" value="Gestion des Questions"/>
<s:include value="../partials/header.jsp" />

<s:div class="container">
  <h1>Gestionnaire de Question</h1>
  <hr/>
  <s:div class="row">
    <s:div class="span8">
      <s:div class="well">
        <s:form action="ajouter_question" method="post">
          <s:div class="form-group">
            <label>Nouvelle Question :</label>
           <s:textfield type="" name="question.contexte" value="%{question.contexte}" class="form-control" theme="simple"/>
          </s:div>
          <hr/>
          <s:div class="btn-group">
            <button type="submit" class="btn btn-success">Ajouter</button>
          </s:div>
        </s:form>
      </s:div>
    </s:div>
    <s:div class="span8">
      <div class="well">
      <table class="table table-bordered">
        <caption>Liste des questions</caption>
        <thead>
          <tr>
            <th>Identifiant</th>
            <th>Question</th>
            <th>Option</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="questionDAO.list()">

           <tr>
             <td> <s:property value="identifiant" /></td>
             <td> <s:property value="contexte" /></td>
             <td>
             <s:form action="supprimer_question" method="post" theme="simple">
               <s:textfield type="hidden" name="question.identifiant" value="%{identifiant}"/>
               <s:submit value="Supprimer" class="btn btn-danger"/>
             </s:form>
             </td>
           </tr>
          </s:iterator>
        </tbody>
      </table>
      </div>
    </s:div>
  </s:div>

</s:div>

<s:include value="../partials/footer.jsp"/>