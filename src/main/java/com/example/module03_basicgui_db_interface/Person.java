package com.example.module03_basicgui_db_interface;

/**
 * Represents a person entity with fields corresponding to a database table.
 */
public class Person {

    // Fields corresponding to columns in the table
    private Integer id;
    private String firstName;
    private String lastName;
    private String dept;
    private String major;

    /**
     * Default constructor for the Person class.
     */
    public Person() {
    }

    /**
     * Constructs a Person object with the specified attributes.
     *
     * @param id        The unique identifier of the person.
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param dept      The department of the person.
     * @param major     The major of the person.
     */
    public Person(Integer id, String firstName, String lastName, String dept, String major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.dept = dept;
    }

    /**
     * Gets the unique identifier of the person.
     *
     * @return The person's ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the person.
     *
     * @param id The person's ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the major of the person.
     *
     * @return The major.
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the major of the person.
     *
     * @param major The major.
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Gets the department of the person.
     *
     * @return The department.
     */
    public String getDept() {
        return dept;
    }

    /**
     * Sets the department of the person.
     *
     * @param dept The department.
     */
    public void setDept(String dept) {
        this.dept = dept;
    }
}
