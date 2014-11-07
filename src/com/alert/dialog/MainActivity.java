package com.alert.dialog;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements Runnable, OnClickListener {

	private static final int MAX_PROGRESS = 100;

	private ProgressDialog mProgressDialog = null;
	 final String[] mItems = {"item0","item1","itme2","item3","itme4","item5","item6"};
	    
	    int mSingleChoiceID = -1;
	    
	    ArrayList <Integer>MultiChoiceID = new ArrayList <Integer>();

		private Dialog mutilDialog;

		private Button button0;

		private AlertDialog.Builder builder;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);
        
        
        
	}
	
		
		
	

	@Override
	public void run() {
		
		
		
		
		
		
		
		
		

	}
	@Override
	public void onClick(View v) {
		builder = new AlertDialog.Builder(MainActivity.this);
		switch (v.getId()) {
		case R.id.button0:
			
			CreateMutilDialog();
			
	            
			break;

		default:
			break;
		}
		
		
		
		
	}




	/**
	 * 功能：创建多个按钮的对话框
	 **/
	private void CreateMutilDialog() {
		builder.setIcon(R.drawable.icon);
		builder.setTitle("你确定吗？");
		builder.setMessage("您确定删除该条信息吗？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				//这里添加点击确定后的逻辑
				mutilDialog.dismiss();
				ToastUtils.disToast(MainActivity.this, "确定了了了了!");
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				//这里添加点击确定后的逻辑
				mutilDialog.dismiss();
				ToastUtils.disToast(MainActivity.this, "取消了了了了!");				
			}
		});
		builder.setNeutralButton("待定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mutilDialog.dismiss();
				ToastUtils.disToast(MainActivity.this, "容我再想想!");				
			}
		});
		mutilDialog = builder.create();
		mutilDialog.show();
		/**
		 * 功能：设置对话框的尺寸大小
		 **/
		WindowManager.LayoutParams params=mutilDialog.getWindow().getAttributes();
		params.width=300;
		params.height=251;
		mutilDialog.getWindow().setAttributes(params);	
	}





	
	
	
	

}
