package com.example.waractivitycontroller.view.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waractivitycontroller.R;
import com.example.waractivitycontroller.model.persistence.DatabaseHelper;
import com.example.waractivitycontroller.model.persistence.contract.PlayerContract;
import com.example.waractivitycontroller.model.persistence.object.Player;

public class AddPlayerActivity extends AppCompatActivity {

    private EditText mNameEdit;
    private EditText mLevelEdit;
    private EditText mDayEdit;
    private EditText mMonthEdit;
    private EditText mYearEdit;

    private Button mAddButton;

    private static final String INSERT_PLAYER = "insert";
    private static final int INSERT_PLAYER_SUCCESS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        mNameEdit = (EditText) findViewById(R.id.activity_add_player_name);
        mLevelEdit = (EditText) findViewById(R.id.activity_add_player_level);
        mDayEdit = (EditText) findViewById(R.id.activity_add_player_day);
        mMonthEdit = (EditText) findViewById(R.id.activity_add_player_month);
        mYearEdit = (EditText) findViewById(R.id.activity_add_player_year);
        mAddButton = (Button) findViewById(R.id.activity_add_player_button);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.getData().getInt(INSERT_PLAYER) != 0){
                switch (msg.getData().getInt(INSERT_PLAYER)){
                    case INSERT_PLAYER_SUCCESS:
                        onBackPressed();
                }
            }
        }
    };

    public void onAddPlayer(View view) {
        mAddButton.setEnabled(false);
        if(!acceptedName()){
            mAddButton.setEnabled(true);
            return;
        }
        if(!acceptedLevel()){
            mAddButton.setEnabled(true);
            return;
        }
        if(!acceptedDay()){
            mAddButton.setEnabled(true);
            return;
        }
        if(!acceptedMonth()){
            mAddButton.setEnabled(true);
            return;
        }
        if(!acceptedYear()){
            mAddButton.setEnabled(true);
            return;
        }
        final Player player = new Player(
                mNameEdit.getText().toString(),
                Integer.parseInt(mLevelEdit.getText().toString()),
                Integer.parseInt(mYearEdit.getText().toString()),
                Integer.parseInt(mMonthEdit.getText().toString()),
                Integer.parseInt(mDayEdit.getText().toString()));

        new AsyncTask<Context, Void, Bundle>() {
            @Override
            protected Bundle doInBackground(Context... params) {
                Bundle bundle = new Bundle();
                bundle.putInt(INSERT_PLAYER, INSERT_PLAYER_SUCCESS);

                DatabaseHelper helper = new DatabaseHelper(params[0]);
                SQLiteDatabase db = helper.openDatabase();

                PlayerContract.insertPlayer(db, player);

                helper.closeDatabase();
                return bundle;
            }

            @Override
            protected void onPostExecute(Bundle bundle) {
                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }.execute(this);
    }

    private boolean acceptedYear() {
        Log.d(AddPlayerActivity.class.getSimpleName(),"checking Year");
        if(mYearEdit.getText().toString().equals("")){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Year empty, setting default Value 0");
            mYearEdit.setText(String.valueOf(0));
            return true;
        }
        if(!TextUtils.isDigitsOnly(mYearEdit.getText().toString())){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Year not only digits");
            Toast.makeText(this,"Only numbers allowed", Toast.LENGTH_SHORT).show();
            mYearEdit.requestFocus();
            return false;
        }
        Log.d(AddPlayerActivity.class.getSimpleName(),"Year accepted: " + mYearEdit.getText().toString());
        return true;
    }

    private boolean acceptedMonth() {
        Log.d(AddPlayerActivity.class.getSimpleName(),"checking Month");
        if(mMonthEdit.getText().toString().equals("")){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Month empty, setting default Value 0");
            mMonthEdit.setText(String.valueOf(0));
            return true;
        }
        if(!TextUtils.isDigitsOnly(mMonthEdit.getText().toString())){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Month not only digits");
            Toast.makeText(this,"Only numbers allowed", Toast.LENGTH_SHORT).show();
            mMonthEdit.requestFocus();
            return false;
        }
        if(Integer.parseInt(mMonthEdit.getText().toString()) < 1 || Integer.parseInt(mMonthEdit.getText().toString()) > 12){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Month out of Bounds");
            Toast.makeText(this, "Only days 1 - 12 allowed", Toast.LENGTH_SHORT).show();
            mMonthEdit.requestFocus();
            return false;
        }
        Log.d(AddPlayerActivity.class.getSimpleName(),"Month accepted: " + mMonthEdit.getText().toString());
        return true;
    }

    private boolean acceptedDay() {
        Log.d(AddPlayerActivity.class.getSimpleName(),"checking Day");
        if(mDayEdit.getText().toString().equals("")){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Day empty, setting default Value 0");
            mDayEdit.setText(String.valueOf(0));
            return true;
        }
        if(!TextUtils.isDigitsOnly(mDayEdit.getText().toString())){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Day not only digits");
            Toast.makeText(this,"Only numbers allowed", Toast.LENGTH_SHORT).show();
            mDayEdit.requestFocus();
            return false;
        }
        if(Integer.parseInt(mDayEdit.getText().toString()) < 1 || Integer.parseInt(mDayEdit.getText().toString()) > 31){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Day out of bounds");
            Toast.makeText(this, "Only days 1 - 31 allowed", Toast.LENGTH_SHORT).show();
            mDayEdit.requestFocus();
            return false;
        }
        Log.d(AddPlayerActivity.class.getSimpleName(),"Day accepted: " + mDayEdit.getText().toString());
        return true;
    }

    private boolean acceptedLevel() {
        Log.d(AddPlayerActivity.class.getSimpleName(),"checking Level");
        if(mLevelEdit.getText().toString().equals("")){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Level empty");
            Toast.makeText(this, "Enter a level", Toast.LENGTH_SHORT).show();
            mLevelEdit.requestFocus();
            return false;
        }
        if(!TextUtils.isDigitsOnly(mLevelEdit.getText().toString())){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Level not only digits");
            Toast.makeText(this,"Only numbers allowed", Toast.LENGTH_SHORT).show();
            mLevelEdit.requestFocus();
            return false;
        }
        if(Integer.parseInt(mLevelEdit.getText().toString()) < 1 || Integer.parseInt(mLevelEdit.getText().toString()) > 50){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Level out of bounds");
            Toast.makeText(this, "Only levels 1 - 50 allowed", Toast.LENGTH_SHORT).show();
            mLevelEdit.requestFocus();
            return false;
        }
        Log.d(AddPlayerActivity.class.getSimpleName(),"Level accepted: " + mLevelEdit.getText().toString());
        return true;
    }

    private boolean acceptedName() {
        Log.d(AddPlayerActivity.class.getSimpleName(),"checking Name");
        if(mNameEdit.getText().toString().equals("")){
            Log.d(AddPlayerActivity.class.getSimpleName(),"Name empty");
            mNameEdit.requestFocus();
            Toast.makeText(this,"Enter a Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d(AddPlayerActivity.class.getSimpleName(),"Name accepted: " + mNameEdit.getText().toString());
        return true;
    }
}
