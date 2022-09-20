
package com.cab.utils;


public class CUD_Response {
    
    private boolean IsSuccess;

    public CUD_Response(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }
    
}
