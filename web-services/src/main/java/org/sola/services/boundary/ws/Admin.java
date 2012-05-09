/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations
 * (FAO). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,this
 * list of conditions and the following disclaimer. 2. Redistributions in binary
 * form must reproduce the above copyright notice,this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. 3. Neither the name of FAO nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT,STRICT LIABILITY,OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.services.boundary.ws;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.common.SOLAException;
import org.sola.common.messaging.ServiceMessage;
import org.sola.services.boundary.transferobjects.security.GroupSummaryTO;
import org.sola.services.boundary.transferobjects.security.GroupTO;
import org.sola.services.boundary.transferobjects.security.RoleTO;
import org.sola.services.boundary.transferobjects.security.UserTO;
import org.sola.services.boundary.transferobjects.system.BrTO;
import org.sola.services.boundary.transferobjects.system.LanguageTO;
import org.sola.services.boundary.transferobjects.system.NepaliMonthTO;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.*;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.system.businesslogic.SystemEJBLocal;
import org.sola.services.ejb.system.repository.entities.Br;
import org.sola.services.ejbs.admin.businesslogic.AdminEJBLocal;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.Group;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.NepaliMonth;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.Role;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.User;

/**
 * Provides methods for administrators to manage users, reference data and
 * system settings.
 */
@WebService(serviceName = "admin-service", targetNamespace = ServiceConstants.ADMIN_WS_NAMESPACE)
public class Admin extends AbstractWebService {

    @EJB
    AdminEJBLocal adminEJB;
    @EJB
    SystemEJBLocal systemEJB;
    @Resource
    private WebServiceContext wsContext;

    /**
     * Dummy method to check the web service instance is working.
     */
    @WebMethod(operationName = "CheckConnection")
    public boolean CheckConnection() {
        return true;
    }

    /**
     * Returns list of all available languages.
     */
    @WebMethod(operationName = "GetLanguages")
    public List<LanguageTO> GetLanguages(String lang)
            throws SOLAFault, UnhandledFault {

        final String langTmp = lang;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        adminEJB.getLanguages(langTmp), LanguageTO.class);
            }
        });

        return (List<LanguageTO>) result[0];
    }

    /**
     * Returns list of all user groups.
     */
    @WebMethod(operationName = "GetGroups")
    public List<GroupTO> GetGroups()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        adminEJB.getGroups(), GroupTO.class);
            }
        });

        return (List<GroupTO>) result[0];
    }

    /**
     * Returns list of all groups summaries.
     */
    @WebMethod(operationName = "GetGroupsSummary")
    public List<GroupSummaryTO> GetGroupsSummary()
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        adminEJB.getGroupsSummary(), GroupSummaryTO.class);
            }
        });

        return (List<GroupSummaryTO>) result[0];
    }

    /**
     * Returns currently logged user
     */
    @WebMethod(operationName = "GetCurrentUser")
    public UserTO GetCurrentUser()
            throws SOLAFault, UnhandledFault {

        //     FLOSS - 813 3      
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        adminEJB.getCurrentUser(), UserTO.class);
            }
        });

        return (UserTO) result[0];
    }

    /**
     * Returns user
     */
    @WebMethod(operationName = "GetUser")
    public UserTO GetUser(@WebParam(name = "userName") String userName)
            throws SOLAFault, UnhandledFault {

        final String userNameTmp = userName;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        adminEJB.getUser(userNameTmp), UserTO.class);
            }
        });

        return (UserTO) result[0];
    }

    /**
     * Saves user.
     */
    @WebMethod(operationName = "SaveUser")
    public UserTO SaveUser(@WebParam(name = "userTO") UserTO userTO) throws SOLAFault, UnhandledFault {

        final UserTO userTOTmp = userTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                User user = adminEJB.getUser(userTOTmp.getUserName());
                if (user != null && userTOTmp != null && user.getUserName() != null
                        && user.getUserName().equals(userTOTmp.getUserName())
                        && !user.getId().equals(userTOTmp.getId())) {
                    throw new SOLAException(ServiceMessage.ADMIN_WS_USER_EXISTS,
                            new String[]{user.getUserName()});

                }
                result[0] = GenericTranslator.toTO(
                        adminEJB.saveUser(GenericTranslator.fromTO(userTOTmp, User.class, user)), UserTO.class);
            }
        });

        return (UserTO) result[0];
    }

    /**
     * Returns group by ID.
     */
    @WebMethod(operationName = "GetGroup")
    public GroupTO GetGroup(@WebParam(name = "groupId") String groupId)
            throws SOLAFault, UnhandledFault {

        final String groupIdTmp = groupId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(adminEJB.getGroup(groupIdTmp),
                        GroupTO.class);
            }
        });

        return (GroupTO) result[0];
    }

    /**
     * Creates/saves group.
     */
    @WebMethod(operationName = "SaveGroup")
    public GroupTO SaveGroup(@WebParam(name = "groupTO") GroupTO groupTO) throws SOLAFault, UnhandledFault {
        //     FLOSS - 813 6     
        final GroupTO groupTOTmp = groupTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                Group group = adminEJB.getGroup(groupTOTmp.getId());
                result[0] = GenericTranslator.toTO(
                        adminEJB.saveGroup(GenericTranslator.fromTO(groupTOTmp, Group.class, group)), GroupTO.class);
            }
        });

        return (GroupTO) result[0];
    }

    @WebMethod(operationName = "GetRoles")
    public List<RoleTO> GetRoles()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        adminEJB.getRoles(), RoleTO.class);
            }
        });

        return (List<RoleTO>) result[0];
    }

    @WebMethod(operationName = "GetCurrentUserRoles")
    public List<RoleTO> GetCurrentUserRoles() throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        adminEJB.getCurrentUserRoles(), RoleTO.class);
            }
        });

        return (List<RoleTO>) result[0];
    }

    /**
     * Update role.
     */
    @WebMethod(operationName = "SaveRole")
    public RoleTO SaveRole(@WebParam(name = "roleTO") RoleTO roleTO) throws SOLAFault, UnhandledFault {


        final RoleTO roleTOTmp = roleTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                Role role = adminEJB.getRole(roleTOTmp.getCode());
                result[0] = GenericTranslator.toTO(
                        adminEJB.saveRole(GenericTranslator.fromTO(roleTOTmp, Role.class, role)), RoleTO.class);
            }
        });

        return (RoleTO) result[0];
    }

    /**
     * Update role.
     */
    @WebMethod(operationName = "ChangePassword")
    public boolean ChangePassword(@WebParam(name = "userName") String userName,
            @WebParam(name = "password") String password) throws SOLAFault, UnhandledFault {

        final String userNameTmp = userName;
        final String passwordTmp = password;
        final boolean[] result = {false};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = adminEJB.changePassword(userNameTmp, passwordTmp);
            }
        });

        return result[0];
    }

    @WebMethod(operationName = "IsUserAdmin")
    public boolean IsUserAdmin() throws SOLAFault, UnhandledFault {

        final boolean[] result = {false};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = adminEJB.isUserAdmin();
            }
        });

        return result[0];
    }

    @WebMethod(operationName = "GetBr")
    public BrTO GetBr(@WebParam(name = "id") String id, @WebParam(name = "lang") String lang)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {
        final Object[] params = {id, lang};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String id = params[0] == null ? null : params[0].toString();
                String languageCode = params[1] == null ? null : params[1].toString();
                result[0] = GenericTranslator.toTO(systemEJB.getBr(
                        id, languageCode), BrTO.class);
            }
        });

        return (BrTO) result[0];
    }

    @WebMethod(operationName = "SaveBr")
    public BrTO SaveBr(@WebParam(name = "br") BrTO br)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {
        final Object[] params = {br};
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                BrTO brTO = (BrTO) params[0];
                Br br = systemEJB.getBr(brTO.getId(), null);
                result[0] = GenericTranslator.toTO(
                        systemEJB.saveBr(GenericTranslator.fromTO(brTO, Br.class, br)),
                        BrTO.class);
            }
        });

        return (BrTO) result[0];
    }

    @WebMethod(operationName = "getGregorianDate")
    public Date getGregorianDate(@WebParam(name = "nepaliDate") final String nepaliDate)
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = adminEJB.getGregorianDate(nepaliDate);
            }
        });

        return (Date) result[0];
    }

    @WebMethod(operationName = "getNepaliDate")
    public String getNepaliDate(@WebParam(name = "date") final Date date)
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = adminEJB.getNepaliDate(date);
            }
        });

        return result[0].toString();
    }

    /**
     * save nepali months
     */
    @WebMethod(operationName = "saveNepaliMonth")
    public List<NepaliMonthTO> saveNepaliMonth(@WebParam(name = "nepaliMonthTO") final List<NepaliMonthTO> nepaliMonthsTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                for(NepaliMonthTO nepMonthTO : nepaliMonthsTO) {
                    NepaliMonth nepMonthEntity = adminEJB.getNepaliMonth(nepMonthTO.getNepYear(), nepMonthTO.getNepMonth());
                    nepMonthTO = GenericTranslator.toTO(
                            adminEJB.saveNepaliMonth(
                            GenericTranslator.fromTO(nepMonthTO, NepaliMonth.class, nepMonthEntity)), NepaliMonthTO.class);
                }
                result[0] = nepaliMonthsTO;
            }
        });

        return (List<NepaliMonthTO>) result[0];
    }

    @WebMethod(operationName = "getNepaliMonths")
    public List<NepaliMonthTO> getNepaliMonths(@WebParam(name = "nepYear") final int nepYear)
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {


                result[0] = GenericTranslator.toTOList(adminEJB.getNepaliMonths(nepYear), NepaliMonthTO.class);
            }
        });

        return (List<NepaliMonthTO>) result[0];
    }
    
    @WebMethod(operationName = "getNepaliYear")
    public List<Integer> getNepaliYear()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getNepaliYear();
            }
        });

        return (List<Integer>) result[0];
    }
    
    
    @WebMethod(operationName = "getLMOCode")
    public List<Integer> getLMOCode()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getLMOCode();
            }
        });

        return (List<Integer>) result[0];
    }
    
    @WebMethod(operationName = "getLMONames")
    public List<String> getLMONames()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getLMONames();
            }
        });

        return (List<String>) result[0];
    }
    
    @WebMethod(operationName = "getDistrictNames")
    public List<String> getDistrictNames()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getDistrictNames();
            }
        });

        return (List<String>) result[0];
    }
    
    @WebMethod(operationName = "getDistrictCodes")
    public List<Integer> getDistrictCodes()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getDistrictCodes();
            }
        });

        return (List<Integer>) result[0];
    }
}
