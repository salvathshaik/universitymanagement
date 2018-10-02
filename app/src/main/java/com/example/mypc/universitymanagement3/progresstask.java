package com.example.mypc.universitymanagement3;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.widget.Toast;

public class progresstask extends AsyncTask<Void,Integer,String>

{   Context ctx;
    ProgressDialog pd;
    //2
    public  progresstask(Context ct)
    {
        ctx=ct;
    }


    @Override

    public void onPreExecute()
    {

        pd = new ProgressDialog(ctx);
        pd.setTitle("Downloading");
        pd.setTitle("please wait");
        pd.setMax(10);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE,"CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        pd.show();
    }
    @Override
    protected String doInBackground(Void... voids) {

        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(6000);
                Log.i("Exception", "Execute" + i);
                publishProgress(i);
            }
            return "sucessful";
        } catch (Exception e) {
            Log.i("Exception", e.getMessage());
            return "Failure";
        }
    }



    protected void onProgressUpdate(Integer...values){
        int myValue=values[0];

        pd.setProgress(myValue);

    }

    @Override
    protected void onPostExecute(String s){
        Toast.makeText(ctx,s,Toast.LENGTH_SHORT).show();
        pd.dismiss();

    }
}

