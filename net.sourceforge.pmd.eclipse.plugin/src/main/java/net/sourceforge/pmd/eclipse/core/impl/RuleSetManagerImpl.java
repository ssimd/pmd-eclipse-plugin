/*
 * Created on 7 juin 2005
 *
 * Copyright (c) 2005, PMD for Eclipse Development Team
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * The end-user documentation included with the redistribution, if
 *       any, must include the following acknowledgement:
 *       "This product includes software developed in part by support from
 *        the Defense Advanced Research Project Agency (DARPA)"
 *     * Neither the name of "PMD for Eclipse Development Team" nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.sourceforge.pmd.eclipse.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sourceforge.pmd.RuleSet;
import net.sourceforge.pmd.eclipse.core.IRuleSetManager;

/**
 *
 *
 * @author Philippe Herlin
 *
 */
public class RuleSetManagerImpl implements IRuleSetManager {
    
    private final List<RuleSet> ruleSets = new ArrayList<RuleSet>();
    private final List<RuleSet> defaultRuleSets = new ArrayList<RuleSet>();

    /**
     * @see net.sourceforge.pmd.eclipse.core.IRuleSetManager#getRegisteredRuleSets()
     */
    public Collection<RuleSet> getRegisteredRuleSets() {
        return ruleSets;
    }

    /**
     * @see net.sourceforge.pmd.eclipse.core.IRuleSetManager#registerRuleSet(net.sourceforge.pmd.RuleSet)
     */
    public void registerRuleSet(RuleSet ruleSet) {
        checkForNull(ruleSet);
        if (!ruleSets.contains(ruleSet)) {
            ruleSets.add(ruleSet);
        }
    }

    /**
     * @see net.sourceforge.pmd.eclipse.core.IRuleSetManager#unregisterRuleSet(net.sourceforge.pmd.RuleSet)
     */
    public void unregisterRuleSet(RuleSet ruleSet) {
        checkForNull(ruleSet);

        ruleSets.remove(ruleSet);
    }

    /**
     * @see net.sourceforge.pmd.eclipse.core.IRuleSetManager#getDefaultRuleSets()
     */
    public Collection<RuleSet> getDefaultRuleSets() {
        return defaultRuleSets;
    }

    /**
     * @see net.sourceforge.pmd.eclipse.core.IRuleSetManager#registerDefaultRuleSet(net.sourceforge.pmd.RuleSet)
     */
    public void registerDefaultRuleSet(RuleSet ruleSet) {
        checkForNull(ruleSet);

        if (!defaultRuleSets.contains(ruleSet)) {
            defaultRuleSets.add(ruleSet);
        }
    }

    /**
     * @see net.sourceforge.pmd.eclipse.core.IRuleSetManager#unregisterDefaultRuleSet(net.sourceforge.pmd.RuleSet)
     */
    public void unregisterDefaultRuleSet(RuleSet ruleSet) {
        checkForNull(ruleSet);

        defaultRuleSets.remove(ruleSet);
    }
    
    private void checkForNull(RuleSet ruleSet) {
        if (ruleSet == null) {
            throw new IllegalArgumentException("ruleSet cannot be null"); // TODO NLS
        }
    }
}
