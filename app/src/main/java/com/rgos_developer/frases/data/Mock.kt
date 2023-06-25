package com.rgos_developer.frases.data

import com.rgos_developer.frases.infra.FrasesConstants
import kotlin.random.Random

data class Phrase(val description:String, val categoryId: Int, val language: String)

class Mock {
    private val sunny = FrasesConstants.FILTER.SUNNY
    private val infinite = FrasesConstants.FILTER.INFINITE
    private val emoji = FrasesConstants.FILTER.EMOJI

    private val pt = FrasesConstants.LANGUAGE.PORTUGUESE
    private val en = FrasesConstants.LANGUAGE.ENGLISH
    private val fr = FrasesConstants.LANGUAGE.FRENCH

    private val mListPhrases = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", emoji, pt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            emoji,
            pt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", emoji, pt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            emoji,
            pt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", emoji, pt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            emoji,
            pt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, pt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, pt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, pt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, pt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, pt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, pt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            sunny,
            pt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", emoji, en),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            emoji,
            en
        ),
        Phrase("When it's darker, we see more stars!", emoji, en),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            emoji,
            en
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", emoji, en),
        Phrase("What can you do now that has the biggest impact on your success?", emoji, en),
        Phrase("The best way to predict the future is to invent it.", sunny, en),
        Phrase("You lose every chance you don't take.", sunny, en),
        Phrase("Failure is the spice that flavors success.", sunny, en),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, en),
        Phrase("If you don't know where you want to go, any way will do.", sunny, en),
        Phrase("If you believe, it makes all the difference.", sunny, en),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            sunny,
            en
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", emoji, fr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            emoji,
            fr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", emoji, fr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            emoji,
            fr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", emoji, fr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            emoji,
            fr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", sunny, fr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", sunny, fr),
        Phrase("L'échec est l'épice qui parfume le succès.", sunny, fr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", sunny, fr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            sunny,
            fr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", sunny, fr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            sunny,
            fr
        )
    )

    fun getPhrase(id: Int, language: String): String {
        val filtered = mListPhrases.filter { (it.categoryId == id || id == infinite) && (it.language == language)}
        return filtered[Random.nextInt(filtered.size)].description
    }

}