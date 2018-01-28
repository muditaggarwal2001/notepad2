package com.example.mudit.notepad2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewNoteActivity extends AppCompatActivity {

    private long noteid;
    private DBHelperClass dbHelperClass;
    private EditText title;
    private EditText note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        title = (EditText)findViewById(R.id.note_title);
        note= (EditText)findViewById(R.id.note_desc);
        dbHelperClass = new DBHelperClass(this);
        dbHelperClass.open();
        noteid=-2;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                if(noteid==-2) {
                    noteid = dbHelperClass.insertData(title.getText().toString(), note.getText().toString(), null);
                    //Add picpath and imageview for images
                    if(noteid!=-1)
                        Toast.makeText(NewNoteActivity.this, "Note Saved Successfully", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(NewNoteActivity.this, "Not enough memory", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.photo:
                if ()
        }
        finish();
        return true;
    }

<<<<<<< HEAD
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperClass.close();
=======
    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(NewNoteActivity.this);
        builder.setTitle("Add Photo!");
        AlertDialog.Builder cancel = builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(NewNoteActivity.this);
                String userChoosenTask;
                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    if (result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    if (result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }

            private void galleryIntent() {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);//
                startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
            }

            private void cameraIntent() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAMERA);
            }

            public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
                switch (requestCode) {
                    case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            String userChoosenTask;
                            if (userChoosenTask.equals("Take Photo"))
                                cameraIntent();
                            else if (userChoosenTask.equals("Choose from Library"))
                                galleryIntent();
                        } else {
                            //code for deny
                        }
                        break;
                }
            }
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (resultCode == Activity.RESULT_OK) {
                    if (requestCode == SELECT_FILE)
                        onSelectFromGalleryResult(data);
                    else if (requestCode == REQUEST_CAMERA)
                        onCaptureImageResult(data);
                }
            }
            @SuppressWarnings("deprecation")
            private void onSelectFromGalleryResult(Intent data) {
                Bitmap bm=null;
                if (data != null) {
                    try {
                        bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                ImageView ivImage;
                ivImage.setImageBitmap(bm);
            }
           

            private void onCaptureImageResult(Intent data) {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                File destination = new File(Environment.getExternalStorageDirectory(),
                        System.currentTimeMillis() + ".jpg");
                FileOutputStream fo;
                try {
                    destination.createNewFile();
                    fo = new FileOutputStream(destination);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageView ivImage;
                ivImage.setImageBitmap(thumbnail);

                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                private void onSelectFromGalleryResult(Intent data) {
                    Bitmap bm=null;
                    if (data != null) {
                        try {
                            bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    ivImage.setImageBitmap(bm);
                }



            });
        builder.show();
>>>>>>> 4698433fc42afc093847dcae424da3eda441100d
    }
}
