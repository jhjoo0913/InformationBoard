package com.kepco.informationboard;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.kepco.informationboard.ConstructionMenu.ConstructionFragment;
import com.kepco.informationboard.HomeMenu.MainFragment;
import com.kepco.informationboard.TroubleCaseMenu.TroubleCaseFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private ConstructionFragment constructionFragment;
    private TroubleCaseFragment troubleCaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        constructionFragment = new ConstructionFragment();
        troubleCaseFragment = new TroubleCaseFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, mainFragment)
                    .commit();
        }

        getFileFromAssets();
    }

    public void onFragmentChange(int index) {
        if (index == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, mainFragment)
                    .commit();
        } else if (index == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, constructionFragment)
                    .commit();
        } else if (index == 2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, troubleCaseFragment)
                    .commit();
        }
    }

    public void showChooser(String filename) {
        String filePath = getFilesDir().getAbsolutePath() + File.separator + filename;
        File file = new File(filePath);

        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Uri uri = FileProvider.getUriForFile(this,
                getApplicationContext().getPackageName() + ".provider", file);

       /* String mimeType = MimeTypeMap.getSingleton()
                .getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath()));*/
        pdfIntent.setDataAndType(uri, "application/pdf");
             /*   Uri.parse("file://" + getFilesDir().getAbsolutePath() + "/" + SAMPLE_FILE),
                "application/pdf"
        );*/
        Intent intent = Intent.createChooser(pdfIntent, "연결 프로그램");
        startActivity(intent);
    }

    private void getFileFromAssets() {
        AssetManager assetManager = getResources().getAssets();
        String[] assets = null;

        try {
            assets = assetManager.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert assets != null;
        for (String asset : assets) {
            if (Pattern.matches(".+\\.pdf$", asset)) {
                moveFile(asset, assetManager);
            }
        }
    }

    private void moveFile(String asset, AssetManager assetManager) {
        InputStream is = null;
        OutputStream out = null;

        String filePath = getFilesDir().getAbsolutePath() + File.separator + asset;
        try {
            is = assetManager.open(asset);
            out = new FileOutputStream(filePath);

            copyFile(is, out);
            is.close();
            is = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void copyFile(InputStream is, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = is.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}