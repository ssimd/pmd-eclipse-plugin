package net.sourceforge.pmd.eclipse.ui.preferences.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import net.sourceforge.pmd.PropertyDescriptor;
import net.sourceforge.pmd.PropertySource;
import net.sourceforge.pmd.eclipse.ui.preferences.br.SizeChangeListener;
import net.sourceforge.pmd.eclipse.ui.preferences.br.ValueChangeListener;
import net.sourceforge.pmd.lang.rule.properties.CharacterProperty;
import net.sourceforge.pmd.util.StringUtil;

/**
 * @author Brian Remedios
 */
public class CharacterEditorFactory extends AbstractEditorFactory<Character> {

    public static final CharacterEditorFactory instance = new CharacterEditorFactory();


    private CharacterEditorFactory() { }


    public PropertyDescriptor<Character> createDescriptor(String name, String description, Control[] otherData) {

        return new CharacterProperty(
            name,
            description,
            'a',
            0);
    }


    protected Character valueFrom(Control valueControl) {

        String value = ((Text) valueControl).getText().trim();

        return (StringUtil.isEmpty(value) || value.length() > 1) ? null
                                                                 : value.charAt(0);
    }


    public Control newEditorOn(Composite parent, final PropertyDescriptor<Character> desc, final PropertySource
        source, final ValueChangeListener listener, SizeChangeListener sizeListener) {

        final Text text = new Text(parent, SWT.SINGLE | SWT.BORDER);

        fillWidget(text, desc, source);

        text.addListener(SWT.FocusOut, new Listener() {
            public void handleEvent(Event event) {
                Character newValue = charValueIn(text);
                Character existingValue = valueFor(source, desc);
                if (existingValue.equals(newValue)) {
                    return;
                }

                source.setProperty(desc, newValue);
                listener.changed(source, desc, newValue);
                adjustRendering(source, desc, text);
            }
        });

        return text;
    }


    /**
     * Method fillWidget.
     *
     * @param textWidget Text
     * @param desc       PropertyDescriptor<?>
     * @param rule       Rule
     */
    protected void fillWidget(Text textWidget, PropertyDescriptor<Character> desc, PropertySource source) {
        Character val = valueFor(source, desc);
        textWidget.setText(val == null ? "" : val.toString());
    }


    private static Character charValueIn(Text textControl) {
        String newValue = textControl.getText().trim();
        if (newValue.length() == 0) {
            return null;
        }
        return newValue.charAt(0);
    }
}
