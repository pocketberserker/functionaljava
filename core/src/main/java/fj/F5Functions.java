package fj;

import fj.data.Validation;

/**
 * Created by MarkPerry on 6/04/2014.
 */
public class F5Functions {

    /**
     * Promotes the TryCatch5 to a Validation that returns an Exception on the failure side and its result on the success side.
     *
     * @param t A TryCatch5 to promote
     * @return A Validation with an Exception on the failure side and its result on the success side.
     */
    static public <A, B, C, D, E, F> F5<A, B, C, D, E, Validation<Exception, F>> toF5(final TryCatch5<A, B, C, D, E, F> t) {
        return (a, b, c, d, e) -> {
            try {
                return Validation.success(t.f(a, b, c, d, e));
            } catch (Exception ex) {
                return Validation.fail(ex);
            }
        };
    }

}