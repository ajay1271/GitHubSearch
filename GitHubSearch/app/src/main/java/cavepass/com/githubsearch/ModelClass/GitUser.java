
package cavepass.com.githubsearch.ModelClass;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitUser implements Serializable, Parcelable
{

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    public final static Parcelable.Creator<GitUser> CREATOR = new Creator<GitUser>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GitUser createFromParcel(Parcel in) {
            return new GitUser(in);
        }

        public GitUser[] newArray(int size) {
            return (new GitUser[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2579253654911847717L;

    protected GitUser(Parcel in) {
        this.totalCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.incompleteResults = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.items, (cavepass.com.githubsearch.ModelClass.Item.class.getClassLoader()));
    }

    public GitUser() {
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalCount);
        dest.writeValue(incompleteResults);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
