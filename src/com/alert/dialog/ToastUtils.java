package com.alert.dialog;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
	
	public static void disToast(Context ctx,String message){
		Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();		
	}
	
	

}