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
		private Button mutilBtn;
		private AlertDialog.Builder builder;
		private Button listBtn;
		private Button progressBtn;
		private Button radioBtn;
		private Button ckeckBoxBtn;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mutilBtn = (Button) findViewById(R.id.button1);
		mutilBtn.setOnClickListener(this);
        
		listBtn = (Button) findViewById(R.id.button2);
		listBtn.setOnClickListener(this);
		
		progressBtn = (Button) findViewById(R.id.button3);
		progressBtn.setOnClickListener(this);
		radioBtn = (Button) findViewById(R.id.button4);
		radioBtn.setOnClickListener(this);
		
		ckeckBoxBtn = (Button) findViewById(R.id.button5);
		ckeckBoxBtn.setOnClickListener(this);
        
        
        
	}
	
		
		
	
	/**
	 * 功能：在这里更新进度条
	 **/
	@Override
	public void run() {
		 int Progress = 0;
		    while(Progress < MAX_PROGRESS) {
			try {
			    Thread.sleep(100);
			    Progress++;  
			    mProgressDialog.incrementProgressBy(1);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			 
		    }
	}
	@Override
	public void onClick(View v) {
		builder = new AlertDialog.Builder(MainActivity.this);
		switch (v.getId()) {
		case R.id.button1:			
			CreateMutilDialog();
			break;
		case R.id.button2:			
			CreateListDialog();
			break;
		case R.id.button3:			
			CreateProgressDialog();
			break;
		case R.id.button4:			
			CreateRadioListDialog();
			break;
		case R.id.button5:			
			CreateCkeckBoxDialog();
			break;
		default:
			break;
		}
		
		
		
		
	}
	
	
	/**
	 * 功能：CheckBox 列表对话框
	 **/
	private void CreateCkeckBoxDialog() {
		 final boolean[] arrayFruitSelected = new boolean[] {true, true, false, false};  
		 builder.setMultiChoiceItems(arrayFruit, arrayFruitSelected, new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				arrayFruitSelected[which]=isChecked;		
			}
		});
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				  StringBuilder stringBuilder = new StringBuilder();  
				  for (int i = 0; i < arrayFruitSelected.length; i++) {  
                      if (arrayFruitSelected[i] == true)  
                      {  
                          stringBuilder.append(arrayFruit[i] + "、");  
                      }  
                  }
				ToastUtils.disToast(MainActivity.this, stringBuilder.toString());
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this,"取消");
			}
		});
		mutilDialog = builder.create();
		mutilDialog.show();
		/**
		 * 功能：设置对话框的尺寸大小
		 **/
		WindowManager.LayoutParams params=mutilDialog.getWindow().getAttributes();
		params.width=300;
		
		mutilDialog.getWindow().setAttributes(params);	
		
		
	}




	/**
	 * 功能：radio 列表对话框
	 **/
	private void CreateRadioListDialog() {
		 selectedFruitIndex = 0;  
		builder.setSingleChoiceItems(arrayFruit, 0, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				selectedFruitIndex=which;				
			}
		});
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this, arrayFruit[selectedFruitIndex]);
				
			}
		});
		builder.setNegativeButton("取消",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this, "取消了");
				
			}
			
		});
		mutilDialog = builder.create();
		mutilDialog.show();
		/**
		 * 功能：设置对话框的尺寸大小
		 **/
		WindowManager.LayoutParams params=mutilDialog.getWindow().getAttributes();
		params.width=300;
		
		mutilDialog.getWindow().setAttributes(params);		
		
	}




	/**
	 * 功能：进度条对话框
	 **/
	@SuppressWarnings("deprecation")
	private void CreateProgressDialog() {
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setIcon(R.drawable.icon);
        mProgressDialog.setTitle("进度条窗口");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setMax(MAX_PROGRESS);
		mProgressDialog.setButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this, "这里是确定 ");
			}
		});
		mProgressDialog.setButton2("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this, "这里是取消 ");
				
			}
		});
		mProgressDialog.show();
		new Thread(this).start();
		
		
	}

	private final String[] arrayFruit = new String[] { "苹果", "橘子", "草莓", "香蕉" };

	private int selectedFruitIndex;  
	
	/**
	 * 功能：创建列表对话框
	 **/
	private void CreateListDialog() {
		builder.setIcon(R.drawable.icon);
		builder.setTitle("你喜欢吃哪种水果？");
		builder.setItems(arrayFruit, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this, arrayFruit[which]);				
			}
		});
		builder.setNegativeButton("取消",  new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				ToastUtils.disToast(MainActivity.this, "取消了了");				
			}			
		});
		
		mutilDialog = builder.create();
		mutilDialog.show();
		/**
		 * 功能：设置对话框的尺寸大小
		 **/
		WindowManager.LayoutParams params=mutilDialog.getWindow().getAttributes();
		params.width=300;
		
		mutilDialog.getWindow().setAttributes(params);			
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
				ToastUtils.disToast(MainActivity.this, "容朕再想想!");				
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
