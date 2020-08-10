package com.oceanebelle.generator.spanishcard.service.spanish;

import com.oceanebelle.generator.spanishcard.database.Conjugation;
import com.oceanebelle.generator.spanishcard.database.ConjugationRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class ConjugationService {
    private ConjugationRepository conjugationRepository;


    @Timed @Counted
    @Transactional
    public String conjugate(SpanishCardGenerator.Voice voice, String verb, Conjugation.ConjugationType type, Supplier<String> fallback) {
        return conjugationRepository.findByIdAndType(verb, type)
                .map(c -> asVoice(c, voice))
                .findFirst()
                .orElseGet(fallback);
    }

    private static String asVoice(Conjugation conjugation, SpanishCardGenerator.Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return conjugation.getFirst();
            case SECOND:
                return conjugation.getSecond();
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return conjugation.getThird();
            case FIRST_PLURAL:
                return conjugation.getFirstPlural();
            case SECOND_PLURAL:
                return conjugation.getSecondPlural();
            case THIRD_PL_MALE:
            case THIRD_PL_FEMALE:
            case THIRD_PL_FORMAL:
                return conjugation.getThirdPlural();
        }
    }
}
