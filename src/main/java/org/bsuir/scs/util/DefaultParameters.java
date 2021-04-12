package org.bsuir.scs.util;

public class DefaultParameters {
    public static final String DEFAULT_PATH = "out\\storage\\";

    public static final String CONCEPT_NODE_TYPE = "sc_node_not_relation";
    public static final String NREL_NODE_TYPE = "sc_node_norole_relation";
    public static final String RREL_NODE_TYPE = "sc_node_role_relation";

    public static final String RUSSIAN_LANGUAGE = "(*<-lang_ru;;*)";
    public static final String ENGLISH_LANGUAGE = "(*<-lang_en;;*)";

    public static final String MAIN_IDTF = "nrel_main_idtf";
    public static final String USING_CONSTANTS = "nrel_using_constants";
    public static final String TEXT_TRANSLATION = "nrel_sc_text_translation";

    public static final String KEY_SC_ELEMENT = "rrel_key_sc_element";
    public static final String EXAMPLE = "rrel_example";

    public static final String DEFINITION = "definition";
    public static final String STATEMENT = "statement";

    public static final String HTML_FLAG = "(*<- lang_ru;; =>nrel_format: format_html;;*)";

    public static final String FIRST_DOMAIN = "nrel_first_domain";
    public static final String SECOND_DOMAIN = "nrel_second_domain";

    public static final String DEFINITIONAL_DOMAIN = "nrel_definitional_domain";

    public static final String COMBINATION = "nrel_combination";

    public static final String ARITY = "arity";

    public static final String MEASUREMENT = "nrel_measurement";

    public static final String ORIENTED_RELATION_INCLUSION = "relation => nrel_inclusion: oriented_relation";
    public static final String BINARY_RELATION_INCLUSION = "relation => nrel_inclusion: binary_relation";

    public static final String SYMMETRIC_RELATION_INCLUSION = "=> nrel_inclusion: symmetric_relation";
    public static final String TRANSITIVE_RELATION_INCLUSION = "=> nrel_inclusion: transitive_relation";
    public static final String REFLEXIVE_RELATION_INCLUSION = "=> nrel_inclusion: reflexive_relation";

    public static final String LINK_START = "<b><sc_element sys_idtf=\"";
    public static final String LINK_END = "</b>";

    public static final String[] TYPES = {"concept","nrel","rrel"};

    private DefaultParameters(){

    }
}
