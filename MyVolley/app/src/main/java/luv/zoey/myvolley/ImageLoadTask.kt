package luv.zoey.myvolley

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

class ImageLoadTask(var urlStr: String, var imageview: ImageView) :
    AsyncTask<Unit, Unit, Bitmap>() {


    override fun onPreExecute() {
        super.onPreExecute()

    }

    override fun doInBackground(vararg params: Unit?): Bitmap {
        var bitmap: Bitmap? = null

        try {
            publishProgress()

            //이전에 만든 비트맵인지 확인한다.
           if(bitmapHash.containsKey(urlStr)){
               // 확인한 후 비트맵을 꺼내주고
                var oldBitmap=bitmapHash.remove(urlStr)
               // 이 비트맵이 비어있지 않으면
                if(oldBitmap!=null){
                    // 이 비트맵을 메모리에서 지워준다.
                    oldBitmap.recycle()
                    oldBitmap=null  // 큰 의미는 없음.
                }
            }

            var url = URL(urlStr)
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            bitmapHash[urlStr] = bitmap

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return bitmap!!

    }

    override fun onProgressUpdate(vararg values: Unit?) {
        super.onProgressUpdate(*values)

    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)

        imageview.setImageBitmap(result)
        //다시 그려주는 역할
        imageview.invalidate()
    }

    companion object{
        private var bitmapHash = HashMap<String,Bitmap>()
    }

}