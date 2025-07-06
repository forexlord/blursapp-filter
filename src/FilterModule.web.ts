import { registerWebModule, NativeModule } from 'expo';

import { FilterModuleEvents } from './FilterModule.types';

class FilterModule extends NativeModule<FilterModuleEvents> {
  PI = Math.PI;
  async setValueAsync(value: string): Promise<void> {
    this.emit('onChange', { value });
  }
  hello() {
    return 'Hello world! 👋';
  }
}

export default registerWebModule(FilterModule, 'FilterModule');
