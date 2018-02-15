# Animated Recycler View
Animated Recycler View Android Library

## Download
> build.gradle
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

...

dependencies {
    implementation 'com.github.prongbang:animatedrecyclerview:1.0.0'
}
```

## How to use
> GroupAdapter.kt
```kotlin
class GroupAdapter(private val context: Context) : AnimatedRecyclerView.Adapter<GroupAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null
    private var mGroups = ArrayList<String>()

    fun setData(mGroups: ArrayList<String>) {
        this.mGroups = mGroups
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val v = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.onBind(context, mGroups[position])
    }

    override fun getItemCount(): Int {
        return mGroups.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val view = itemView
        private val tvName = itemView.findViewById<AppCompatTextView>(R.id.tvName)

        fun onBind(context: Context, group: String) {
            tvName.text = group
            view.setOnClickListener {
                onClickListener?.onClick(it, group)
            }
            view.setBackgroundColor(generateColor())
        }
    }

    private fun generateColor(): Int {
        val red = (Math.random() * 200).toInt()
        val green = (Math.random() * 200).toInt()
        val blue = (Math.random() * 200).toInt()
        return Color.rgb(red, green, blue)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(v: View, group: String)
    }
}
```

> MainActivity.kt
```kotlin

  val adapter = GroupAdapter(this)
  adapter.setOnClickListener(object : GroupAdapter.OnClickListener {
      override fun onClick(v: View, group: String) {
          Log.i(MainActivity::class.java.simpleName, group)
      }
  })
  rvGroupName.layoutManager = GridLayoutManager(this, 4)
  rvGroupName.adapter = adapter

  // group data
  val groups = ArrayList<String>()
  groups.add("A")
  groups.add("B")
  groups.add("C")
  groups.add("D")
  groups.add("E")
  groups.add("F")
  groups.add("G")
  groups.add("H")
  groups.add("I")
  groups.add("J")
  groups.add("K")
  groups.add("L")
  groups.add("M")
  groups.add("N")
  groups.add("O")
  groups.add("P")
  groups.add("Q")
  groups.add("R")
  groups.add("S")
  groups.add("T")
  groups.add("U")
  groups.add("V")
  groups.add("W")
  groups.add("X")
  groups.add("Y")
  groups.add("Z")
  adapter.setData(groups)

```

> activity_main.xml
```xml
<android.support.v7.widget.RecyclerView
    android:id="@+id/rvGroupName"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
> item_group.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="?attr/selectableItemBackground"
    android:padding="16dp">

    <android.support.v7.widget.AppCompatTextView
        android:id="@+id/tvName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:textColor="#f7f7f7"
        android:text="Name" />

</LinearLayout>
```

### Thank