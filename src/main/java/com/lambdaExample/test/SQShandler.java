package com.lambdaExample.test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class SQShandler implements RequestHandler<SQSEvent, Void>{

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		LambdaLogger logger = context.getLogger();
        for(SQSMessage msg : event.getRecords()){
            System.out.println(new String(msg.getBody()));
            logger.log("message body" + msg.getBody() );
        }
        logger.log("EVENT: success" );
        logger.log("EVENT TYPE: sqs event" );
        return null;
	}

}
