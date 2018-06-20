
package cavepass.com.githubsearch.ModelClass;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class License implements Serializable, Parcelable
{

    private String key;
    private String name;
    private String spdxId;
    private String url;
    private String nodeId;
    public final static Parcelable.Creator<License> CREATOR = new Creator<License>() {


        @SuppressWarnings({
            "unchecked"
        })
        public License createFromParcel(Parcel in) {
            return new License(in);
        }

        public License[] newArray(int size) {
            return (new License[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6543520083087991202L;

    protected License(Parcel in) {
        this.key = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.spdxId = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.nodeId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public License() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpdxId() {
        return spdxId;
    }

    public void setSpdxId(String spdxId) {
        this.spdxId = spdxId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(key);
        dest.writeValue(name);
        dest.writeValue(spdxId);
        dest.writeValue(url);
        dest.writeValue(nodeId);
    }

    public int describeContents() {
        return  0;
    }

}
