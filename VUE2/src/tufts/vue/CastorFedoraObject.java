/*
 * -----------------------------------------------------------------------------
 *
 * <p><b>License and Copyright: </b>The contents of this file are subject to the
 * Mozilla Public License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License
 * at <a href="http://www.mozilla.org/MPL">http://www.mozilla.org/MPL/.</a></p>
 *
 * <p>Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.</p>
 *
 * <p>The entire file consists of original code.  Copyright &copy; 2003, 2004 
 * Tufts University. All rights reserved.</p>
 *
 * -----------------------------------------------------------------------------
 */

/*
 * CastorFedoraObject.java
 *
 * Created on October 21, 2003, 6:13 PM
 */

package tufts.vue;

/**
 *
 * @author  akumar03
 */
// this object exists only for saving and restoring assets
import osid.dr.*;
import tufts.oki.dr.fedora.*;

public class CastorFedoraObject {
    String pid;
    String fedoraType;
    CastorDR castorDR;
    DR dr;
    FedoraObject object;
    FedoraObjectAssetType fedoraObjectAssetType;
    String displayName;
    
    public CastorFedoraObject() {
         try {
            this.castorDR = new CastorDR();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public CastorFedoraObject(FedoraObject object) {
        try {
            this.pid = object.getId().getIdString();
            this.displayName = object.getDisplayName();
            this.castorDR = new CastorDR(object.getDR());
            this.fedoraType = ((FedoraObjectAssetType)object.getAssetType()).getType();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public FedoraObject getFedoraObject() {
        try  {
            dr = castorDR.getDR();
            fedoraObjectAssetType =  dr.createFedoraObjectAssetType(fedoraType);
            object = new FedoraObject(dr,pid,displayName,fedoraObjectAssetType);
            return object;
            } catch(Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
        }
    }
    
    public void setPid(String pid) {
        this.pid  = pid;
    }
    public String getPid() {
        return this.pid;
    }
    
    public void setFedoraType(String fedoraType) {
        this.fedoraType = fedoraType;
    }
    public String getFedoraType() {
        return this.fedoraType;
    }
    public void setCastorDR(CastorDR castorDR)  {
        this.castorDR = castorDR;
    }
    public CastorDR getCastorDR() {
        return this.castorDR;
    }
    public void setdisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return this.displayName;
    }
}
