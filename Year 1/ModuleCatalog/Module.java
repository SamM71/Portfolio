/*
Blueprint for modules
 */

public class Module {

    private final int level;
    private final int code;
    private final String name;
    private final String deptCode;
    private final String deptName;

    /*
    Constructor for the Module class.
     */
    public Module(int level, int code, String name, String deptCode) {
        this.level = level;
        this.code = code;
        this.name = name;
        this.deptCode = deptCode;
        this.deptName = determineDepartment(deptCode);
    }

    public int getLevel() {
        return level;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDeptCode() {
        return deptCode;
    }

    /*
    Returns the correctly formatted string.
     */
    public String toString() {
        return getDeptCode() + ":" + getLevel() + "-" + getCode() + " " + getName() + " (" + deptName +")";
    }

    /*
    Works out the department name based on the department code.
     */
    public String determineDepartment(String deptCode) {
        String departmentName = "";
        if (deptCode == "CS") {
            departmentName = "Computer Science";
        } else if (deptCode == "MA") {
            departmentName = "Mathematics";
        }
        return departmentName;
    }


}
