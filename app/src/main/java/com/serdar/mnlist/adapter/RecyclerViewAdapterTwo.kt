import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.serdar.mnlist.R
import com.serdar.mnlist.data.grocery.Grocery
import com.serdar.mnlist.view.bottomBar.HomeFragmentDirections

class RecyclerViewAdapterTwo: RecyclerView.Adapter<RecyclerViewAdapterTwo.MyViewHolder>() {

    private var groceryList = emptyList<Grocery>()
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val shopStore=view.findViewById<TextView>(R.id.shopStores)
        val shopSize=view.findViewById<TextView>(R.id.shopSizes)
        val shopName=view.findViewById<TextView>(R.id.shopNames)

        fun bind(grocery: Grocery){
            shopName.setText(grocery.size.toString())
            shopSize.setText(grocery.store)
            shopStore.setText(grocery.name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerViewAdapterTwo.MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_view2,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapterTwo.MyViewHolder, position: Int) {
        val currentGrocery=groceryList[position]
        holder.bind(currentGrocery)
        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateGroceryFragment(currentGrocery)
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return groceryList.size
    }
    fun setData(groceryList: List<Grocery>){
        this.groceryList=groceryList
        notifyDataSetChanged()
    }
}