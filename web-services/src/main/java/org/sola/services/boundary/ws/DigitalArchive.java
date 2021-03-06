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

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.services.boundary.transferobjects.digitalarchive.DocumentBinaryTO;
import org.sola.services.boundary.transferobjects.digitalarchive.DocumentTO;
import org.sola.services.boundary.transferobjects.digitalarchive.FileBinaryTO;
import org.sola.services.boundary.transferobjects.digitalarchive.FileInfoTO;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.OptimisticLockingFault;
import org.sola.services.common.faults.SOLAFault;
import org.sola.services.common.faults.UnhandledFault;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.digitalarchive.businesslogic.DigitalArchiveEJBLocal;
import org.sola.services.digitalarchive.repository.entities.Document;

/**
 * Implementation class of the digital archive web service.
 *
 * @see DigitalArchiveEJBLocal
 */
@WebService(serviceName = "digitalarchive-service", targetNamespace = ServiceConstants.DIGITAL_ARCHIVE_WS_NAMESPACE)
public class DigitalArchive extends AbstractWebService {

    @EJB
    private DigitalArchiveEJBLocal digitalArchiveEJB;
    @Resource
    private WebServiceContext wsContext;

    /**
     * Dummy method to check the web service instance is working
     */
    @WebMethod(operationName = "CheckConnection")
    public boolean CheckConnection() {
        return true;
    }

    /**
     * Returns document from digital archive.
     *
     * @param documentId Document id in digital archive.
     * @return
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "GetDocument")
    public DocumentBinaryTO GetDocument(@WebParam(name = "documentId") String documentId)
            throws SOLAFault, UnhandledFault {

        final String documentIdTmp = documentId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(digitalArchiveEJB.getDocument(documentIdTmp),
                        DocumentBinaryTO.class);
            }
        });

        return (DocumentBinaryTO) result[0];
    }

    /**
     * Saves document into digital archive.
     *
     * @param documentTO Transfer object, representing document.
     * @return Saved document.
     * @throws SOLAFault
     * @throws UnhandledFault
     * @throws OptimisticLockingFault
     */
    @WebMethod(operationName = "SaveDocument")
    public DocumentTO SaveDocument(@WebParam(name = "documentTO") DocumentTO documentTO)
            throws SOLAFault, UnhandledFault, OptimisticLockingFault {

        final DocumentTO documentTOTmp = documentTO;
        final Object[] result = {null};

        runDocumentMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                Document document = digitalArchiveEJB.saveDocument(GenericTranslator.fromTO(documentTOTmp,
                        Document.class, digitalArchiveEJB.getDocument(documentTOTmp.getId())));
                result[0] = GenericTranslator.toTO(document, DocumentTO.class);
            }
        });

        return (DocumentTO) result[0];
    }

    /**
     * Creates document in the digital archive.
     *
     * @param documentBinaryTO Transfer object, representing document with
     * binary content.
     * @return Created document
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "CreateDocument")
    public DocumentTO CreateDocument(@WebParam(name = "documentTO") DocumentBinaryTO documentBinaryTO)
            throws SOLAFault, UnhandledFault {

        final DocumentBinaryTO documentBinaryTOTmp = documentBinaryTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                Document document = digitalArchiveEJB.createDocument(GenericTranslator.fromTO(documentBinaryTOTmp, Document.class, null));
                result[0] = GenericTranslator.toTO(document, DocumentTO.class);
            }
        });

        return (DocumentTO) result[0];
    }

    /**
     * Creates document in the digital archive from the file in shared folder.
     *
     * @param documentTO Transfer object, representing document data excluding
     * binary content.
     * @param fileName
     * @return Created document
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "CreateDocumentFromServer")
    public DocumentTO CreateDocumentFromServer(@WebParam(name = "documentTO") DocumentTO documentTO,
            @WebParam(name = "fileName") String fileName) throws SOLAFault, UnhandledFault {

        final DocumentTO documentTOTmp = documentTO;
        final String fileNameTmp = fileName;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                Document document = digitalArchiveEJB.createDocument(GenericTranslator.fromTO(documentTOTmp, Document.class, null), fileNameTmp);
                result[0] = GenericTranslator.toTO(document, DocumentTO.class);
            }
        });

        return (DocumentTO) result[0];
    }

    /**
     * Returns binary file and meta data on it from the shared folder.
     *
     * @param fileName File name in the shared folder.
     * @return
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "GetFileBinary")
    public FileBinaryTO GetFileBinary(@WebParam(name = "fileName") String fileName)
            throws SOLAFault, UnhandledFault {

        final String fileNameTmp = fileName;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(digitalArchiveEJB.getFileBinary(fileNameTmp), FileBinaryTO.class);
            }
        });

        return (FileBinaryTO) result[0];
    }

    /**
     * Returns binary file and meta data of thumbnail.
     *
     * @param fileName File name of the file in the shared folder.
     * @return
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "GetFileThumbnail")
    public FileBinaryTO GetFileThumbnail(@WebParam(name = "fileName") String fileName)
            throws SOLAFault, UnhandledFault {
        //     FLOSS - 813 4       

        final String fileNameTmp = fileName;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(digitalArchiveEJB.getFileThumbnail(fileNameTmp), FileBinaryTO.class);
            }
        });

        return (FileBinaryTO) result[0];
    }

    /**
     * Returns the list of all files from the shared folder.
     *
     * @return
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "GetAllFiles")
    public List<FileInfoTO> GetAllFiles() throws SOLAFault, UnhandledFault {

        //     FLOSS - 813 5      

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(digitalArchiveEJB.getAllFiles(), FileInfoTO.class);
            }
        });

        return (List<FileInfoTO>) result[0];
    }

    /**
     * Deletes file and corresponding thumbnail from the shared folder.
     *
     * @param fileName File name in the shared folder.
     * @return
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "DeleteFile")
    public boolean DeleteFile(@WebParam(name = "fileName") String fileName)
            throws SOLAFault, UnhandledFault {

        final String fileNameTmp = fileName;
        final boolean[] result = {true};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = digitalArchiveEJB.deleteFile(fileNameTmp);
            }
        });

        return result[0];
    }

    /**
     * Rotates image file in the shared folder.
     *
     * @param fileName File name in the shared folder.
     * @param angle Rotation angle.
     * @return
     * @throws SOLAFault
     * @throws UnhandledFault
     */
    @WebMethod(operationName = "RotateImage")
    public boolean RotateImage(@WebParam(name = "fileName") String fileName, @WebParam(name = "angle") int angle)
            throws SOLAFault, UnhandledFault {
        throw new SOLAFault("Not yet implemented", null);
    }
}
