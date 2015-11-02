package pl.com.mmadry.questionnaire.report.web.assembler.commons;


/**
 * Interface for assemblers
 *
 * @param <T1> dbo objects type
 * @param <T2> dto objects type
 * @param <P>  assembler parameters type
 */
public interface Assembler<T1, T2, P> {

    /**
     * Converet dto objects to dbo objects
     *
     * @param parameters assembler parameters
     * @return           dbo object
     */
    T1 assemblyToDbo(P parameters);

    /**
     * Converet dbo objects to dto objects
     *
     * @param parameters assembler parameters
     * @return           dto object
     */
    T2 assemblyToDto(P parameters);

}
