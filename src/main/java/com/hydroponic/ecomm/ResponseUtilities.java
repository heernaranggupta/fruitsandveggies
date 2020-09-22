package com.hydroponic.ecomm;

import com.hydroponic.ecomm.model.CommonResponse;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ResponseUtilities {
    public static CommonResponse createSuccessResponse(CommonResponse commonResponse) {
        commonResponse.setCode(200);
        commonResponse.setMessage(null);
        commonResponse.setSuccess(true);
        commonResponse.setTimestamp(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        return commonResponse;
    }
}
