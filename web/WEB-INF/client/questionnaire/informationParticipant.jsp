<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
{
  "participants" : <s:property value="%{participantDAO.nombreParticipant(questionnaire.identifiant)}" />,
  "terminer"     : <s:property value="%{evaluationDAO.nombrePersonneTerminer(questionnaire.identifiant)}" />
}