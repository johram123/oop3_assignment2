package appDomain;

/**
 * Represents a single XML tag and the line number where it appears in the document.
 * Used for tracking tag positions in stack/queue structures during XML validation.
 */
public class Tag {
    public String tag;

    public int lineNumber;

    /**
     * Constructs a Tag instance with the specified tag name and line number.
     *
     * @param tag The name of the tag (without angle brackets)
     * @param lineNumber The line number where the tag was found
     */
    public Tag(String tag, int lineNumber) {
        this.tag = tag;
        this.lineNumber = lineNumber;
    }
    
    /**
     * Determines if two Tag objects are equal by comparing their tag names.
     *
     * @param obj the object to compare to
     * @return true if the tag names match, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tag other = (Tag) obj;
        return this.tag.equals(other.tag);
    }

   
}
